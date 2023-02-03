package co.com.sofka.challenge.persistence.mapper;

import co.com.sofka.challenge.domain.dto.BuyDTO;
import co.com.sofka.challenge.persistence.entity.Buy;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BuyProductMapper.class})
public interface BuyMapper {

    @Mappings({
            @Mapping(target = "idBuy",source = "idBuy"),
            @Mapping(target = "date",source = "date"),
            @Mapping(target = "idType",source = "idType"),
            @Mapping(target = "clientName",source = "clientName"),
            @Mapping(target = "products",source = "products")
    })
    BuyDTO toBuyDTO(Buy buy);

    @Mappings({
            @Mapping(target = "idBuy",source = "idBuy"),
            @Mapping(target = "clientName",source = "clientName"),
            @Mapping(target = "date",source = "date"),
            @Mapping(target = "idType",source = "idType"),
            @Mapping(target = "products",source = "products")
    })
    Buy toBuy(BuyDTO buyDTO);

    List<BuyDTO> toBuyDTOS(List<Buy> buys);
    List<Buy> toBuys(List<BuyDTO> buyDTOS);
}

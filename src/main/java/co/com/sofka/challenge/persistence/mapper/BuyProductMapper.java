package co.com.sofka.challenge.persistence.mapper;

import co.com.sofka.challenge.domain.dto.BuyProductDTO;
import co.com.sofka.challenge.persistence.entity.BuyProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface BuyProductMapper {

    @Mappings({
            @Mapping(source = "id.idProduct",target = "productId"),
            @Mapping(source = "quantity",target = "quantity")
    })
    BuyProductDTO toBuyProductDTO(BuyProduct buyProduct);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "buy", ignore = true),
            @Mapping(target = "id.idBuy", ignore = true),
            @Mapping(target = "product", ignore = true)
    })
    BuyProduct toBuyProduct(BuyProductDTO buyProductDTO);

    List<BuyProductDTO> toBuyProductDTOS(List<BuyProduct> buyProducts);
    List<BuyProduct> toBuyProducts(List<BuyProductDTO> productDTOS);
}

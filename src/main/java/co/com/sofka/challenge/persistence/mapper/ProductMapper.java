package co.com.sofka.challenge.persistence.mapper;

import co.com.sofka.challenge.domain.dto.ProductDTO;
import co.com.sofka.challenge.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProduct",target = "idProduct"),
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "inInventory",target = "inInventory"),
            @Mapping(source = "enabled",target = "enabled"),
            @Mapping(source = "min",target = "min"),
            @Mapping(source = "max",target = "max")
    })
    Product toProduct(ProductDTO productDTO);
    @InheritInverseConfiguration
    ProductDTO toProductDTO(Product product);
    List<Product> toProducts(List<ProductDTO> productDTOS);
    List<ProductDTO> toProductDTOS(List<Product> products);
}

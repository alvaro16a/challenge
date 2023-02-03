package co.com.sofka.challenge.domain.repository;

import co.com.sofka.challenge.domain.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductDTORepository {

    List<ProductDTO> getAll();
    List<ProductDTO> getAvailable();
    Optional<ProductDTO> getProductDTO(int idProduct);
    ProductDTO save(ProductDTO productDTO);
    void delete(int idProduct);

}

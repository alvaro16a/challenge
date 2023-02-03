package co.com.sofka.challenge.persistence;

import co.com.sofka.challenge.domain.dto.ProductDTO;
import co.com.sofka.challenge.domain.repository.ProductDTORepository;
import co.com.sofka.challenge.persistence.crud.ProductCrudRepository;
import co.com.sofka.challenge.persistence.entity.Product;
import co.com.sofka.challenge.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductRepository implements ProductDTORepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDTO> getAll() {
        return mapper.toProductDTOS((List<Product>) productCrudRepository.findAll());
    }

    @Override
    public List<ProductDTO> getAvailable() {
        return mapper.toProductDTOS((List<Product>) productCrudRepository.findByEnabledOrderByNameAsc(true));
    }

    @Override
    public Optional<ProductDTO> getProductDTO(int idProduct) {
        Optional<Product> product=productCrudRepository.findById(idProduct);
        return product.map(producto -> mapper.toProductDTO(producto));
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product= productCrudRepository.save(mapper.toProduct(productDTO));
        return mapper.toProductDTO(product);
    }

    @Override
    public void delete(int idProduct) {
        productCrudRepository.deleteById(idProduct);
    }
}

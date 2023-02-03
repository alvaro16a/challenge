package co.com.sofka.challenge.domain.service;

import co.com.sofka.challenge.domain.dto.ProductDTO;
import co.com.sofka.challenge.domain.repository.ProductDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductDTORepository productDTORepository;

    public List<ProductDTO> getAll(){
        return productDTORepository.getAll();
    }
    public List<ProductDTO> getAvailable(){
        return productDTORepository.getAvailable();
    }
    public Optional<ProductDTO> getProductoDTO(int idProduct){
        return productDTORepository.getProductDTO(idProduct);
    }
    public ProductDTO save(ProductDTO productDTO){
        return productDTORepository.save(productDTO);
    }
    public boolean delete(int idProduct){
        return getProductoDTO(idProduct).map(product -> {
            productDTORepository.delete(idProduct);
            return true;
        }).orElse(false);
    }
    public boolean update(ProductDTO producto) {
        return getProductoDTO(producto.getIdProduct()).map(product -> {
            productDTORepository.save(producto);
            return true;
        }).orElse(false);
    }
}

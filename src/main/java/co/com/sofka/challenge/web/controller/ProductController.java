package co.com.sofka.challenge.web.controller;

import co.com.sofka.challenge.domain.dto.ProductDTO;
import co.com.sofka.challenge.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll(){

        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO producto){
        return new ResponseEntity<>(productService.save(producto),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody ProductDTO producto){

        if(productService.update(producto)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/available")
    public ResponseEntity<List<ProductDTO>> getAvailable(){
        return new ResponseEntity<>(productService.getAvailable(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProducto(@PathVariable("id") int idProducto){
        return productService.getProductoDTO(idProducto).map(productDTO -> new ResponseEntity<>(productDTO,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int idProducto){
        if(productService.delete(idProducto)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}

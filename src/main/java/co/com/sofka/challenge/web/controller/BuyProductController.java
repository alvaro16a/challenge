package co.com.sofka.challenge.web.controller;

import co.com.sofka.challenge.domain.dto.BuyDTO;
import co.com.sofka.challenge.domain.dto.BuyProductDTO;
import co.com.sofka.challenge.domain.dto.ProductDTO;
import co.com.sofka.challenge.domain.service.BuyService;
import co.com.sofka.challenge.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/buyproduct")
public class BuyProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private BuyService buyService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody BuyDTO buyDTO){
        List<BuyProductDTO> productosComprados = buyDTO.getProducts();
        boolean isEnabled = productosComprados.stream().noneMatch(producto -> (productService.getProductoDTO(producto.getProductId()).get().getEnabled()) == false);
        if(isEnabled){
            boolean isPossible = productosComprados.stream().noneMatch(
                    producto
                            -> producto.getQuantity() < productService.getProductoDTO(producto.getProductId()).get().getMin()
                            || producto.getQuantity() > productService.getProductoDTO(producto.getProductId()).get().getMax());

            if(isPossible){
                boolean inStock = productosComprados.stream().noneMatch(
                        producto -> producto.getQuantity() > productService.getProductoDTO(producto.getProductId()).get().getInInventory());

                if(inStock){
                    return new ResponseEntity<>("hay suficiente en inventario",HttpStatus.ACCEPTED);
                }else{
                    return new ResponseEntity<>("No hay suficientes productos en inventario revise",HttpStatus.BAD_REQUEST);
                }

            }else{
                return new ResponseEntity<>("No es posible realizar la operacion revise maximos y minimos",HttpStatus.BAD_REQUEST);
            }

        }else{
            return new ResponseEntity<>("No todos los productos estan disponibles",HttpStatus.BAD_REQUEST);
        }
    }
}


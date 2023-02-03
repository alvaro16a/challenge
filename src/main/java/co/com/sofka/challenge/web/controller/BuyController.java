package co.com.sofka.challenge.web.controller;

import co.com.sofka.challenge.domain.dto.BuyDTO;
import co.com.sofka.challenge.domain.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buys")
public class BuyController {
    @Autowired
    private BuyService buyService;

    @GetMapping
    public ResponseEntity<List<BuyDTO>> getAll(){
        return new ResponseEntity<>(buyService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BuyDTO> save(@RequestBody BuyDTO buyDTO){
        return new ResponseEntity<>(buyService.save(buyDTO),HttpStatus.CREATED);
    }

    @GetMapping("/client/{clientName}")
    public ResponseEntity<List<BuyDTO>> getByClient(@PathVariable("clientName") String clientName) {
        return buyService.getByClient(clientName).map(
                buyDTOS -> new ResponseEntity<>(buyDTOS, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

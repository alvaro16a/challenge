package co.com.sofka.challenge.domain.service;

import co.com.sofka.challenge.domain.dto.BuyDTO;
import co.com.sofka.challenge.domain.dto.ProductDTO;
import co.com.sofka.challenge.domain.repository.BuyDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyService {

    @Autowired
    private BuyDTORepository buyDTORepository;

    public List<BuyDTO> getAll(){
        return buyDTORepository.getAll();
    }
    public Optional<List<BuyDTO>> getByClient(String clientName){
        return buyDTORepository.getByClient(clientName);
    }
    public Optional<BuyDTO> getBuyDTO(int idBuy){
        return buyDTORepository.getBuyDTO(idBuy);
    }
    public BuyDTO save(BuyDTO buyDTO){
        return buyDTORepository.save(buyDTO);
    }

}

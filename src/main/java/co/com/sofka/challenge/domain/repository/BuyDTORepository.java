package co.com.sofka.challenge.domain.repository;

import co.com.sofka.challenge.domain.dto.BuyDTO;

import java.util.List;
import java.util.Optional;

public interface BuyDTORepository {

    List<BuyDTO> getAll();
    Optional<List<BuyDTO>> getByClient(String clientName);
    Optional<BuyDTO> getBuyDTO(int idBuy);
    BuyDTO save(BuyDTO buyDTO);

}

package co.com.sofka.challenge.persistence;

import co.com.sofka.challenge.domain.dto.BuyDTO;
import co.com.sofka.challenge.domain.repository.BuyDTORepository;
import co.com.sofka.challenge.persistence.crud.BuyCrudRepository;
import co.com.sofka.challenge.persistence.entity.Buy;
import co.com.sofka.challenge.persistence.mapper.BuyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class BuyRepository implements BuyDTORepository {
    @Autowired
    private BuyCrudRepository buyCrudRepository;
    @Autowired
    private BuyMapper mapper;

    @Override
    public List<BuyDTO> getAll() {
        return mapper.toBuyDTOS((List<Buy>)buyCrudRepository.findAll());
    }

    @Override
    public Optional<List<BuyDTO>> getByClient(String clientName) {
        return buyCrudRepository.findByClientName(clientName)
                .map(buys -> mapper.toBuyDTOS(buys));
    }

    @Override
    public Optional<BuyDTO> getBuyDTO(int idBuy) {
        return buyCrudRepository.findById(idBuy).map(buy -> mapper.toBuyDTO(buy));
    }

    @Override
    public BuyDTO save(BuyDTO buyDTO) {
        Buy buy = mapper.toBuy(buyDTO);
        buy.getProducts().forEach(product -> product.setBuy(buy));
        return mapper.toBuyDTO(buyCrudRepository.save(buy)) ;
    }
}

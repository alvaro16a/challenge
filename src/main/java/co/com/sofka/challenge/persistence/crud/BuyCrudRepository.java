package co.com.sofka.challenge.persistence.crud;

import co.com.sofka.challenge.persistence.entity.Buy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BuyCrudRepository extends CrudRepository<Buy,Integer> {

    Optional<List<Buy>> findByClientName(String clientName);

}

package co.com.sofka.challenge.persistence.crud;

import co.com.sofka.challenge.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCrudRepository extends CrudRepository<Product,Integer> {

    List<Product> findByEnabledOrderByNameAsc(Boolean enabled);

}

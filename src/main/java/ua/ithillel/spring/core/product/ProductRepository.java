package ua.ithillel.spring.core.product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll();
    Optional<Product> findById(Integer id);
}

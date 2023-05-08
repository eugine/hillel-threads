package ua.ithillel.spring.core.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryProductRepository implements ProductRepository {
    private final List<Product> db;

    public InMemoryProductRepository(List<Product> initial) {
        this.db = new ArrayList<>(initial);
    }

    @Override
    public List<Product> findAll() {
        return db.stream().toList();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return db.stream()
                .filter(product -> id.equals(product.id()))
                .findAny();
    }
}

package ua.ithillel.spring.core.card;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.ithillel.spring.core.product.ProductRepository;

import java.util.HashMap;
import java.util.Map;

@Component
//@Scope("prototype")
public class Cart {
    private final ProductRepository productRepository;
    private final Map<Integer, CartItem> products;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.products = new HashMap<>();
    }

    public void add(Integer id) {
        productRepository.findById(id).ifPresent(product -> products.put(id, new CartItem(product, 1)));
    }

    public void delete(Integer id) {
        products.remove(id);
    }

    public int totalPrice() {
        return products.values().stream()
                .mapToInt(item -> item.product().price() * item.quantity())
                .sum();
    }

    @Override
    public String toString() {
        return "Cart {" +
                "\nproducts=" + products +
                "\ntotal=" + totalPrice() +
                "\n}";
    }
}

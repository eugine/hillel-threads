package ua.ithillel.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ua.ithillel.spring.core.product.InMemoryProductRepository;
import ua.ithillel.spring.core.product.Product;
import ua.ithillel.spring.core.product.ProductRepository;

import java.util.List;

@Configuration
@ComponentScan("ua.ithillel.spring.core")
public class Config {

    @Bean
    public ProductRepository productRepository() {
        return new InMemoryProductRepository(List.of(
                new Product(1, "product-1", 100),
                new Product(2, "product-2", 200),
                new Product(3, "product-3", 300)
        ));
    }

}

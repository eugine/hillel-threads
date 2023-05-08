package ua.ithillel.spring.core.card;

import ua.ithillel.spring.core.product.Product;

public record CartItem(Product product, int quantity) { }

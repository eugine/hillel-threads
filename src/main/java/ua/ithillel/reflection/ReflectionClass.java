package ua.ithillel.reflection;

import ua.ithillel.hausaufgabe.streams.Product;

import java.util.List;
import java.util.Locale;

public class ReflectionClass {
    private final String name;
    private int age;

    public ReflectionClass(String name) {
        this.name = name;
    }

    @SuppressWarnings("raw")
    @ReflectionAnnotation
    public static List<Product> filterByCategoryAndPriceGreaterThan(List<Product> products, String category, double minPrice) {
        return products.stream()
                .filter(product -> category.equals(product.category()))
                .filter(product -> product.price() > minPrice)
                .toList();
    }

    public String toUpperCase(String name) {
        return name.toUpperCase(Locale.ROOT);
    }

}

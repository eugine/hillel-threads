package ua.ithillel.hausaufgabe.streams;

import ua.ithillel.utils.CollectionUtils;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toMap;

public class ProductUtils {

    @SuppressWarnings("raw")
    public static List<Product> filterByCategoryAndPriceGreaterThan(List<Product> products, String category, double minPrice) {
        return products.stream()
                .filter(product -> category.equals(product.category()))
                .filter(product -> product.price() > minPrice)
                .toList();
    }

    public static List<Product> filterByCategoryAndDiscountable(List<Product> products, String category) {
        return products.stream()
                .filter(Product::discountable)
                .filter(product -> category.equals(product.category()))
                .toList();
    }

    public static Product findCheapest(List<Product> products) {
        return products.stream()
                .min(comparing(Product::price))
                .orElseThrow();
    }

    public static List<Product> findLatest(List<Product> products, int countLatest) {
        return products.stream()
                .sorted(comparing(Product::creationDate).reversed())
                .limit(countLatest)
                .toList();
    }

    public static double calculatePrice(List<Product> products, String category, double minPrice, Duration createdAfter) {
        var now = LocalDate.now();
        return filterByCategoryAndPriceGreaterThan(products, category, minPrice).stream()
                .filter(product -> Duration.between(now, product.creationDate()).compareTo(createdAfter) <= 0)
                .mapToDouble(Product::price)
                .sum();
    }

    public static Map<String, List<Product>> mapByCategories(List<Product> products) {
        return products.stream().collect(toMap(Product::category, List::of, CollectionUtils::mergeLists));
    }

}

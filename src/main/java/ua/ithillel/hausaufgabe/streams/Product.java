package ua.ithillel.hausaufgabe.streams;

import java.time.LocalDate;

public record Product(String category, double price, boolean discountable,LocalDate creationDate) {
}

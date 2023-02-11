package ua.ithillel.hausaufgabe.hw6;

import java.util.List;

public interface HomeworkList {
    int countOccurrence(List<String> items, String value);

    <T> List<T> toList(T[] array);

    <T> List<T> findUnique(List<T> items);

    List<String> calcOccurrence(List<String> items);

    List<NameOccurrence> findOccurrence(List<String> items);
}

package ua.ithillel.hausaufgabe.hw6;

import java.util.List;

public interface HomeworkList {
    <T> int countOccurrence(List<T> items, T value);

    <T> List<T> toList(T[] array);

    <T> List<T> findUnique(List<T> items);

    List<String> calcOccurrence(List<String> items);

    List<NameOccurrence> findOccurrence(List<String> items);
}

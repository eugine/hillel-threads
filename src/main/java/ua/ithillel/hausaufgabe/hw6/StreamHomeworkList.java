package ua.ithillel.hausaufgabe.hw6;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class StreamHomeworkList implements HomeworkList {

    @Override
    public int countOccurrence(List<String> items, String value) {
        return (int) items.stream()
                .filter(item -> Objects.equals(item, value))
                .count();
    }

    @Override
    public <T> List<T> toList(T[] array) {
        return Arrays.stream(array).toList();
    }

    @Override
    public <T> List<T> findUnique(List<T> items) {
        return items.stream()
                .distinct()
                .toList();
    }

    @Override
    public List<String> calcOccurrence(List<String> items) {
        return findOccurrence(items).stream()
                .map(occurrence -> occurrence.name() + ": " + occurrence.occurrence())
                .toList();
    }

    @Override
    public List<NameOccurrence> findOccurrence(List<String> items) {
        return items.stream()
                .collect(toMap(identity(), item -> 1, Integer::sum))
                .entrySet()
                .stream()
                .map(entry -> new NameOccurrence(entry.getKey(), entry.getValue()))
                .toList();
    }


}


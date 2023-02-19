package ua.ithillel.hausaufgabe.hw6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SimpleHomeworkList implements HomeworkList {

    @Override
    public <T> int countOccurrence(List<T> items, T value) {
        int count = 0;
        for (T item : items) {
            if (Objects.equals(item, value)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public <T> List<T> toList(T[] array) {
        var list = new ArrayList<T>();
        Collections.addAll(list, array);
        return list;
    }

    @Override
    public <T> List<T> findUnique(List<T> items) {
        var result = new ArrayList<T>();
        for (T item : items) {
            if (!result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public List<String> calcOccurrence(List<String> items) {
        var result = new ArrayList<String>();
        var processed = new ArrayList<String>();
        for (String item : items) {
            if (!processed.contains(item)) {
                result.add(item + ": " + countOccurrence(items, item));
                processed.add(item);
            }
        }
        return result;
    }

    @Override
    public List<NameOccurrence> findOccurrence(List<String> items) {
        var result = new ArrayList<NameOccurrence>();
        for (String item : findUnique(items)) {
            result.add(new NameOccurrence(item, countOccurrence(items, item)));
        }
        return result;
    }

}


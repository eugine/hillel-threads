package ua.ithillel.hausaufgabe.hw6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SimpleHomeworkList implements HomeworkList {

    @Override
    public int countOccurrence(List<String> items, String value) {
        int count = 0;
        for (String item : items) {
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
        var processed = new ArrayList<String>();
        for (String item : items) {
            if (!processed.contains(item)) {
                result.add(new NameOccurrence(item, countOccurrence(items, item)));
                processed.add(item);
            }
        }
        return result;
    }

}


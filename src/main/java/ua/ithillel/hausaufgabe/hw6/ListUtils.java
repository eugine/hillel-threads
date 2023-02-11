package ua.ithillel.hausaufgabe.hw6;

import java.util.List;
import java.util.Objects;

public class ListUtils {

    public static int countOccurrence(List<String> items, String value) {
        int count = 0;
        for (String item : items) {
            if (Objects.equals(item, value)) {
                count++;
            }
        }
        return count;
    }

}


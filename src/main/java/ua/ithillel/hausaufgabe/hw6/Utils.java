package ua.ithillel.hausaufgabe.hw6;

import java.util.List;

public class Utils {

    public static int countOccurrence(List<String> list, String item) {
        int count = 0;
        for (String value: list) {
            if (value.equals(item)) {
                count++;
            }
        }
        return count;
    }

}


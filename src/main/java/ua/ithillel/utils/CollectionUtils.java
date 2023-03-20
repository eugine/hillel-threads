package ua.ithillel.utils;

import java.util.List;
import java.util.stream.Stream;

public class CollectionUtils {

    public static <T> List<T> mergeLists(List<T> list1, List<T> list2) {
        return Stream.concat(list1.stream(), list2.stream()).toList();
    }
}

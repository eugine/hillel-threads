package ua.ithillel.collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        fillCollection(items);

        for (var item : items) {
            System.out.println("Item: " + item);
        }

        var iter = items.listIterator();
        System.out.println(iter.hasNext());
        System.out.println(iter.hasPrevious());
        System.out.println("-----------------" + iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.hasPrevious());
        System.out.println("-----------------" + iter.previous());
        iter.previous();

    }

    private static void fillCollection(Collection<String> collection) {
        collection.add("one");
        collection.add("one");
        collection.add("two");
        collection.add("three");
        collection.add("three");
    }
}

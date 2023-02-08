package ua.ithillel.collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        fillCollection(list);

        var listIterator = list.listIterator();

        for (var item: list) {

        }

        System.out.println(listIterator.hasNext());
        System.out.println(listIterator.hasPrevious());
        System.out.println("-----------------" + listIterator.next());
        System.out.println(listIterator.hasNext());
        System.out.println(listIterator.hasPrevious());
        System.out.println("-----------------" + listIterator.previous());
        listIterator.previous();

    }

    private static void fillCollection(Collection collection) {
        collection.add("one");
//        collection.add("one");
        collection.add("two");
        collection.add("three");
        collection.add("three");
    }
}

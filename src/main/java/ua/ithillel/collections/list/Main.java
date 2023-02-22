package ua.ithillel.collections.list;

import ua.ithillel.hausaufgabe.hw7.maps.FileData;

import java.util.*;

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

    /*

1. Створити клас FileData. Клас представляє конкретний файл і складається з: ім'я файлу, розміру в байтах, шлях до файлу.
2. Реалізувати метод add у класі FileNavigator. Цей метод додає файл за вказаним шляхом.

     */

    private static class FileNavigator {
        private Map<String, List<FileData>> files = new HashMap<>();

        public void add(String path, FileData file) {

        }

        public List<FileData> find(String path) {
            return null;
        }

        protected Map<String, List<FileData>> getAll() {
            return files;
        }


    }



}

package ua.ithillel.threads.advanced.concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapExample {
    public static void main(String[] args) {
        var map = new ConcurrentHashMap<String, String>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        map.get("key3");

        System.out.println(map);

    }
}

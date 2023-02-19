package ua.ithillel.collections.maps;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // створення
        Map<String, Integer> map = new TreeMap<String, Integer>();

        var mapWithGenerics = new TreeMap<String, Integer>();
        var unmodifiableMap = Map.of(
                "key1", "name1",
                "key2", "name2");

        // додавання, доступ до елементів

        map.put("secret", 1111);
        map.get("secret");


        //raw map
        Map rawMap = new HashMap();
        rawMap.put("key1", 1111);
        rawMap.put("key2", "other_value");

        //включення
        boolean containsKey = map.containsKey("secret");
        boolean containsValue = map.containsValue(2222);

        //коллекції
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();
        //stream від коллекції

        //додавання
        var map2 = new HashMap<String, Integer>();
        map2.putAll(map);

        //видалення
        map.remove("other_key");

        //розмір
        map.size();


        map.put("secret", 2222);

        //мердж
        map.merge("secret", 3333, (v1, v2) -> v1 + v2);


    }
}

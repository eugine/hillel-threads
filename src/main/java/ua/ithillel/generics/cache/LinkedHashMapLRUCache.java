package ua.ithillel.generics.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapLRUCache<K,V> implements Cache<K,V>{

    private final LinkedHashMap<K,V> cache;

    public LinkedHashMapLRUCache(int maxSize) {
        cache  = new LinkedHashMap<>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > maxSize;
            }
        };
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
    }

    @Override
    public V get(K key) {
        return cache.get(key);
    }

    @Override
    public V remove(K key) {
        return cache.remove(key);
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public int size() {
        return cache.size();
    }
}

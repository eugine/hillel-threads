package ua.ithillel.generics.cache;

import java.util.LinkedList;

public class LRUCache<K, V> implements Cache<K, V> {

    private final int maxSize;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }



    public static void main(String[] args) {
        var cache = new LRUCache<Integer, String>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.get(1);

        cache.put(4, "D");
    }
}

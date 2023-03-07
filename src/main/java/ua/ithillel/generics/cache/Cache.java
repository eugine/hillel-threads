package ua.ithillel.generics.cache;

public interface Cache<K, V> {
    void put(K key, V value);

    V get(K key);

    V remove(K key);

    void clear();

    int size();
}

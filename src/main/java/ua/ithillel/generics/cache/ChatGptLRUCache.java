package ua.ithillel.generics.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

/**
 * Assignment: Implement a Generic Cache
 * <p>
 * In this assignment, you will implement a generic cache data structure using Java generics.
 * A cache is a temporary storage area that holds frequently accessed data so that it can be quickly retrieved.
 * Your cache should be able to hold any type of object, and should support the following operations:
 * <p>
 * put(K key, V value): Adds an item of type V to the cache with a corresponding key of type K.
 * get(K key): Returns the item of type V in the cache with the specified key of type K, or null if the key is not present in the cache.
 * remove(K key): Removes the item from the cache with the specified key of type K, if it exists.
 * clear(): Clears all items from the cache.
 * size(): Returns the number of items currently in the cache.
 * Your cache should have a maximum size, specified at construction time, and should evict the least-recently-used item when it reaches its maximum size.
 * <p>
 * You should implement your cache as a generic class called LRUCache<K, V>,
 * where K is the type of object used as a key in the cache, and V is the type of object that the cache will hold.
 * Your cache should be implemented using a linked list to keep track of the least-recently-used items, and a hash table to allow for fast lookup by key.
 * <p>
 * In addition to implementing the cache itself, you should also write a small program that uses your LRUCache<K, V> class to demonstrate its functionality.
 * Your program should:
 * Create an instance of LRUCache<String, Integer> with a maximum size of 3.
 * Use the put() method to add a few key/value pairs to the cache.
 * Use the get() method to retrieve a value from the cache, and print it out.
 * Use the remove() method to remove an item from the cache.
 * Use the clear() method to clear all items from the cache.
 * Use the size() method to print out the number of items currently in the cache.
 * Your program should demonstrate that your cache works correctly, and should handle any error conditions appropriately.
 */
public class ChatGptLRUCache<K, V> implements Cache<K, V> {
    private final int maxSize;
    private final Map<K, Pair<K, V>> cacheMap = new HashMap<>();
    private final LinkedList<Pair<K, V>> cacheList = new LinkedList<>();

    public ChatGptLRUCache(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void put(K key, V value) {
        var entry = new Pair<>(key, value);

        if (cacheMap.containsKey(key)) {
            cacheList.remove(entry);
        } else if (cacheList.size() >= maxSize) {
            var leastRecentlyUsed = cacheList.removeLast();
            cacheMap.remove(leastRecentlyUsed.key);
        }
        cacheList.addFirst(entry);
        cacheMap.put(key, entry);
    }

    @Override
    public V get(K key) {
        return Optional.ofNullable(cacheMap.get(key)).stream()
                .peek(cacheList::remove)
                .peek(cacheList::addFirst)
                .map(Pair::value)
                .findAny()
                .orElse(null);
    }

    @Override
    public V remove(K key) {
        var removed = cacheMap.remove(key);
        if (removed != null) {
            cacheList.remove(removed);
        }
        return removed.value;
//
//
//        return Optional.ofNullable().stream()
//                .peek(cacheList::remove)
//                .findAny()
//                .map(Pair::value)
//                .orElse(null)null;
    }

    @Override
    public void clear() {
        cacheList.clear();
        cacheMap.clear();
    }

    @Override
    public int size() {
        return cacheList.size();
    }

    private record Pair<K, V>(K key, V value) {
    }
}

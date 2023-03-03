package ua.ithillel.generics;

class LinkedHashMapLRUCacheTest extends CacheTest{

    @Override
    Cache<Integer, String> getTarget(int maxSize) {
        return new LinkedHashMapLRUCache<>(maxSize);
    }
}
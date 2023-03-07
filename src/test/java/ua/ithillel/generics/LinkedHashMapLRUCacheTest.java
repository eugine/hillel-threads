package ua.ithillel.generics;

import ua.ithillel.generics.cache.Cache;
import ua.ithillel.generics.cache.LinkedHashMapLRUCache;

class LinkedHashMapLRUCacheTest extends CacheTest{

    @Override
    Cache<Integer, String> getTarget(int maxSize) {
        return new LinkedHashMapLRUCache<>(maxSize);
    }
}
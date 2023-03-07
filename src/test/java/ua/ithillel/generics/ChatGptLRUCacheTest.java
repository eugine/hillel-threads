package ua.ithillel.generics;

import ua.ithillel.generics.cache.Cache;
import ua.ithillel.generics.cache.ChatGptLRUCache;

class ChatGptLRUCacheTest extends CacheTest {

    @Override
    Cache<Integer, String> getTarget(int maxSize) {
        return new ChatGptLRUCache<>(maxSize);
    }
}
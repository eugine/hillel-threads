package ua.ithillel.generics;

class ChatGptLRUCacheTest extends CacheTest {

    @Override
    Cache<Integer, String> getTarget(int maxSize) {
        return new ChatGptLRUCache<>(maxSize);
    }
}
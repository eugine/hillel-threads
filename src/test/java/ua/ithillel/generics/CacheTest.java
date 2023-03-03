package ua.ithillel.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

abstract class CacheTest {

    private final Cache<Integer, String> target = this.getTarget(2);

    abstract Cache<Integer, String> getTarget(int maxSize);

    @Test
    public void shouldPutAndGet() {
        target.put(1, "one");
        target.put(2, "two");
        assertEquals("one", target.get(1));
        assertEquals("two", target.get(2));
    }

    @Test
    public void shouldEvictTheOldest() {
        target.put(1, "one");
        target.put(2, "two");
        target.put(3, "three");
        assertNull(target.get(1));
        assertEquals("two", target.get(2));
        assertEquals("three", target.get(3));
    }

    @Test
    public void shouldRemove() {
        target.put(1, "one");
        target.put(2, "two");
        target.remove(1);
        assertNull(target.get(1));
        assertEquals("two", target.get(2));
    }

    @Test
    public void shouldClear() {
        target.put(1, "one");
        target.put(2, "two");
        target.clear();
        assertNull(target.get(1));
        assertNull(target.get(2));
        assertEquals(0, target.size());
    }

    @Test
    public void shouldReturnCorrectSize() {
        assertEquals(0, target.size());
        target.put(1, "one");
        assertEquals(1, target.size());
        target.put(2, "two");
        assertEquals(2, target.size());
        target.put(3, "three");
        assertEquals(2, target.size());
        target.remove(2);
        assertEquals(1, target.size());
        target.clear();
        assertEquals(0, target.size());
    }
}
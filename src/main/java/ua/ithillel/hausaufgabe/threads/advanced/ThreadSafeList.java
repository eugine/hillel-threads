package ua.ithillel.hausaufgabe.threads.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeList<T> {
    private final List<T> items = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void add(T value) {
        lock.writeLock().lock();
        try {
            items.add(value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public T remove(int index) {
        lock.writeLock().lock();
        try {
            return items.remove(index);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public T get(int index) {
        lock.readLock().lock();
        try {
            return items.get(index);
        } finally {
            lock.readLock().unlock();
        }
    }
}

package ua.ithillel.threads.advanced.counters;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Counter {

    private final AtomicInteger counter = new AtomicInteger();

    public void increment() {
        counter.incrementAndGet();
    }

    public int getValue() {
        return counter.get();
    }
}

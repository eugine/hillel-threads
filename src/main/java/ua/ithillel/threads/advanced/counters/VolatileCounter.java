package ua.ithillel.threads.advanced.counters;

public class VolatileCounter implements Counter {
    private volatile int counter;

    public void increment() {
        counter++;
    }

    public int getValue() {
        return counter;
    }
}

package ua.ithillel.threads.advanced.counters;

public class SynchronizedCounter implements Counter {

    private int counter;

    public synchronized void increment() {
        counter++;
    }

    public synchronized int getValue() {
        return counter;
    }
}

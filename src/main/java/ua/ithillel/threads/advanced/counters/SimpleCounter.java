package ua.ithillel.threads.advanced.counters;

public class SimpleCounter implements Counter {

    private int counter;

    @Override
    public void increment() {
        counter++;
    }

    @Override
    public int getValue() {
        return counter;
    }
}

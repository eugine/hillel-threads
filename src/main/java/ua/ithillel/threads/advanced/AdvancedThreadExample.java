package ua.ithillel.threads.advanced;

import java.util.ArrayList;

public class AdvancedThreadExample {

    public static void main(String[] args) {
        var state = new State("alarm", 0);

        var threads = new ArrayList<Thread>();
        for (int i = 0; i < 1_000; i++) {
            var thread = new Thread(() -> updateState(state));
            threads.add(thread);
            thread.start();
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(state);
    }

    private static void updateState(State state) {
        state.setStatus("alarm" + (state.getCounter() + 1));
        state.setCounter(state.getCounter() + 1);
    }
}

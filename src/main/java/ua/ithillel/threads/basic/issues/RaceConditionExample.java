package ua.ithillel.threads.basic.issues;

import java.util.ArrayList;

public class RaceConditionExample {

    public static void main(String[] args) {
        var state = new RaceConditionState("alarm0", 0);

        var threads = new ArrayList<Thread>();
        for (int i = 0; i < 1_000; i++) {
            var thread = new Thread(() -> updateState(state));
            threads.add(thread);
//            thread.start();
        }
        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(state);
    }

    private static void updateState(RaceConditionState state) {
        state.status = "alarm" + (state.counter + 1);
        state.counter = state.counter + 1;
    }

    private static class RaceConditionState {
        private String status;
        private int counter;

        public RaceConditionState(String status, int counter) {
            this.status = status;
            this.counter = counter;
        }

        @Override
        public String toString() {
            return "State{" +
                    "status='" + status + '\'' +
                    ", counter=" + counter +
                    '}';
        }
    }
}

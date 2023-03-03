package ua.ithillel.threads.basic.issues;

import lombok.SneakyThrows;

import static ua.ithillel.utils.LogUtils.log;

public class DeadLockExample {

    private static class Monitor implements Runnable {
        private final String name;
        private Monitor anotherMonitor;

        private Monitor(String name) {
            this.name = name;
        }

        public void setAnotherMonitor(Monitor anotherMonitor) {
            this.anotherMonitor = anotherMonitor;
        }

        @SneakyThrows
        public void doJob() {
            synchronized (this) {
                log("doJob in " + name);
                Thread.sleep(1_000);
                anotherMonitor.doAnotherJob();
            }
        }

        public synchronized void doAnotherJob() {
            log("doAnotherJob in " + name);
        }

        @Override
        public void run() {
            doJob();
        }
    }

    public static void main(String[] args) {
        var monitor1 = new Monitor("Monitor 1");
        var monitor2 = new Monitor("Monitor 2");

        monitor1.setAnotherMonitor(monitor2);
        monitor2.setAnotherMonitor(monitor1);

        var thread1 = new Thread(monitor1);
        var thread2 = new Thread(monitor2);

        thread1.start();
        thread2.start();
    }
}

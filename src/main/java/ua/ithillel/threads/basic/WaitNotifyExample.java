package ua.ithillel.threads.basic;

import static ua.ithillel.utils.LogUtils.log;

public class WaitNotifyExample {


    private static class Monitor implements Runnable {
        public synchronized void doJob() {
            log("starting a job");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log("resuming a job");
        }

        @Override
        public void run() {
            doJob();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var example = new Monitor();

        var thread = new Thread(example);
        thread.start();

        Thread.sleep(1_000);

        synchronized (example) {
            example.notify();
        }
    }


}


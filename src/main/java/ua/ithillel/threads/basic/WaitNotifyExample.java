package ua.ithillel.threads.basic;

import static ua.ithillel.utils.LogUtils.log;

public class WaitNotifyExample {


    private static class Monitor {
        public synchronized void doJob() {
            log("starting a job");
            try {
                wait(5_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log("resuming a job");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var example = new Monitor();

        var thread = new Thread(example::doJob);
        thread.start();
//        Thread.sleep(1_000);
//
//        synchronized (example) {
//            example.notify();
//        }
    }


}


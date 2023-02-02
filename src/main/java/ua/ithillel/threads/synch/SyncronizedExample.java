package ua.ithillel.threads.synch;

import java.util.random.RandomGenerator;

public class SyncronizedExample {
    public static void main(String[] args) throws InterruptedException {

        var thread1 = new Thread(SyncronizedExample::doJob, "thread-1");
        var thread2 = new Thread(SyncronizedExample::doJob, "thread-2");
        var thread3 = new Thread(SyncronizedExample::doJob, "thread-3");

        thread1.start(); // thread-1
        thread2.start(); // thread-2
        thread3.start(); // thread-2
    }

    public static void doJob() {
        System.out.println("Thread " + Thread.currentThread().getName() + " started a job");
        try {
            Thread.sleep(RandomGenerator.getDefault().nextInt(5) * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " finished");

    }
}

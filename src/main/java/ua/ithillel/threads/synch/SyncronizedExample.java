package ua.ithillel.threads.synch;

import java.util.random.RandomGenerator;

public class SyncronizedExample {
    public static void main(String[] args) throws InterruptedException {

        var thread1 = new Thread(SyncronizedExample::doJob, "thread-1");
        var thread2 = new Thread(SyncronizedExample::doJob, "thread-2");
        var thread3 = new Thread(SyncronizedExample::doJob, "thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
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

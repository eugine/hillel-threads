package ua.ithillel.threads.advanced.locks;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static ua.ithillel.utils.LogUtils.log;

public class LocksExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var executorService = Executors.newFixedThreadPool(5);

        var task = new Task();

        var future1 = executorService.submit(task);
        var future2 = executorService.submit(task);

        future1.get();
        future2.get();

        executorService.shutdown();
    }

    public static class Task implements Runnable {
        private final Lock lock = new ReentrantLock();

        public void startJob() {
            log("locking");
            lock.lock();
            log("started");
        }

        public void endJob() {
            lock.unlock();
            log("ended");
        }

        @Override
        public void run() {
            startJob();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            endJob();
        }
    }
}

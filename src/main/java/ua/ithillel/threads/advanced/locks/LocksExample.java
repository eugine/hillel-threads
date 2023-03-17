package ua.ithillel.threads.advanced.locks;

import ua.ithillel.utils.ThreadUtils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static ua.ithillel.utils.LogUtils.log;

public class LocksExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var task = new Task();
        var thread1 = new Thread(task);
        var thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    public static class Task implements Runnable {
        private final Lock lock = new ReentrantLock();

        public void startJob() {
            log("locking");
            lock.lock();
            log("started");
        }

        public void endJob() {
            log("ended");
            lock.unlock();
        }

        @Override
        public void run() {
            startJob();
            ThreadUtils.sleep(2000);
            endJob();
        }
    }
}
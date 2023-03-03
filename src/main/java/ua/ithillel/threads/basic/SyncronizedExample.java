package ua.ithillel.threads.basic;

import lombok.SneakyThrows;
import ua.ithillel.utils.LogUtils;

public class SyncronizedExample implements Runnable {
    private final Object lock;

    public SyncronizedExample(Object lock) {
        this.lock = lock;
    }

    @SneakyThrows
    public void doJob() {
        synchronized (lock) {
            LogUtils.log("start synchronized part");
            Thread.sleep(1_000);
            LogUtils.log("end synchronized part");
        }
    }

    @Override
    public void run() {
        doJob();
    }

    public static void main(String[] args) {
        var lock = new Object();

        var task1 = new SyncronizedExample(lock);
        var task2 = new SyncronizedExample(lock);
        var task3 = new SyncronizedExample(lock);

        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();
    }


}

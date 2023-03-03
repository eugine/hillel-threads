package ua.ithillel.threads.basic;

import lombok.SneakyThrows;

import static ua.ithillel.utils.LogUtils.log;

public class DaemonThreadExample {

    public static void main(String[] args) {
        log("started main");
        var thread = new Thread(new SleepTask());
        thread.setDaemon(true);

        thread.start();
        log("end main");
        while (true) {
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static class SleepTask implements Runnable {

        @Override
        @SneakyThrows
        public void run() {
            log("sleep started");
            Thread.sleep(5_000);
            log("sleep ended");
        }
    }

}

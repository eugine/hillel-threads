package ua.ithillel.threads.basic.issues;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.stream.IntStream;

import static ua.ithillel.utils.LogUtils.log;

public class DifferentMonitorExample {

//    public static synchronized long sum(int[] array) {
    public synchronized long sum(int[] array) {
        var start = System.currentTimeMillis();
        var sum = 0;
        for (int value : array) {
            sum += value;
        }
        log("Sum calculated in " + (System.currentTimeMillis() - start));
        return sum;
    }

    public static void main(String[] args) {
        var array = new int[1_000_000_000];
        Arrays.fill(array, 15);

        var start = System.currentTimeMillis();
        runParallel(array, 10);
        log("Parallel completed in " + (System.currentTimeMillis() - start));

    }

    private static void runParallel(int[] array, int threadCount) {
//        Runnable sumRunnable = () -> sum(array);
        Runnable sumRunnable = () -> new DifferentMonitorExample().sum(array);

        var threads = IntStream.rangeClosed(0, threadCount)
                .mapToObj(index ->  new Thread(sumRunnable, "parallel-" + index))
                .toList();

        threads.forEach(Thread::start);
        threads.forEach(DifferentMonitorExample::joinThread);
    }


    @SneakyThrows
    private static void joinThread(Thread thread) {
        thread.join();
    }
}

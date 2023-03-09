package ua.ithillel.threads.advanced.executors;

import ua.ithillel.utils.LogUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var executor = Executors.newFixedThreadPool(5);

        Future<?> runnableFuture = executor.submit(new Runnable() {
            @Override
            public void run() {
                LogUtils.log("do job in runnable");
            }
        });

        Future<String> callableFuture = executor.submit(new Callable<String>() {
            @Override
            public String call() {
                LogUtils.log("do job in callable");
                return "Callable done";
            }
        });

        runnableFuture.get();
        var result = callableFuture.get();
        LogUtils.log("Result: " + result);

        executor.shutdown();
    }

}

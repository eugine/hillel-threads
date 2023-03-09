package ua.ithillel.hausaufgabe.threads.advanced;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class SimpleCalculator {
    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    @SneakyThrows
    public int squareSum(int first, int second) {
        return supplyAsync(() -> first * first, executor)
                .thenCombine(supplyAsync(() -> second * second, executor), Integer::sum)
                .get();
    }

    public void shutdown() {
        executor.shutdown();
    }
}

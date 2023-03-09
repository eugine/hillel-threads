package ua.ithillel.threads.advanced.future;

import ua.ithillel.utils.ThreadUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import static ua.ithillel.utils.LogUtils.log;

public class EnhancedExample {

    public static CompletableFuture<String> calculateAsync() {
        return supplyAsync(() -> {
            log("Running");
            ThreadUtils.sleep(500);
            return "Hello";
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = calculateAsync()
                .thenCombine(supplyAsync(() -> {
                            log("Running 2");
                            return "world";
                        }),
                        (s1, s2) -> s1 + " " + s2)
                .thenApply((result) -> {
                    log("Running 3");
                    return result + "!";
                });

        log("Result: " + future.get());
    }


}

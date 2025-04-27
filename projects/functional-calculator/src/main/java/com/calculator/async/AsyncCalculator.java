package com.calculator.async;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class AsyncCalculator {
    public static <T> CompletableFuture<T> calculateAsync(
        Function<T, T> operation,
        T input
    ) {
        return CompletableFuture.supplyAsync(() -> operation.apply(input));
    }

    public static CompletableFuture<Double> calculateAsync(
        Function<Double, Double> operation,
        Double input,
        long delayMillis
    ) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return operation.apply(input);
        });
    }
}
package com.calculator;

import com.calculator.async.AsyncCalculator;
import com.calculator.composer.OperationComposer;
import java.util.function.Function;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        FunctionalCalculator calc = new FunctionalCalculator();

        // Operações básicas
        System.out.println("\nOperações básicas:");
        System.out.println("5 + 3 = " + calc.add(5.0).apply(3.0));
        System.out.println("10 - 4 = " + calc.subtract(10.0).apply(4.0));
        System.out.println("6 * 2 = " + calc.multiply(6.0).apply(2.0));
        System.out.println("15 / 3 = " + calc.divide(15.0).apply(3.0));
        System.out.println("2 ^ 3 = " + calc.power(2.0).apply(3.0));
        System.out.println("√16 = " + calc.sqrt().apply(16.0));

        // Composição de operações
        System.out.println("\nComposição de operações:");
        Function<Double, Double> complexOperation = OperationComposer.compose(
            calc.add(5.0),
            calc.multiply(2.0),
            calc.power(2.0)
        );
        System.out.println("((3 + 5) * 2) ^ 2 = " + complexOperation.apply(3.0));

        // Operações assíncronas
        System.out.println("\nOperações assíncronas:");
        CompletableFuture<Double> futureResult = AsyncCalculator.calculateAsync(
            calc.add(10.0),
            5.0,
            1000
        );
        
        futureResult.thenAccept(result -> 
            System.out.println("Resultado assíncrono (10 + 5): " + result)
        );

        // Histórico de operações
        System.out.println("\nHistórico de operações:");
        calc.getHistory().getHistory().forEach(System.out::println);

        // Aguardar operações assíncronas
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
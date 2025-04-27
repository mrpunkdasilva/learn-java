package com.calculator.composer;

import java.util.Arrays;
import java.util.function.Function;

public class OperationComposer {
    public static <T> Function<T, T> compose(Function<T, T>... functions) {
        return Arrays.stream(functions)
                    .reduce(Function.identity(), Function::andThen);
    }

    public static <T> Function<T, T> pipe(Function<T, T>... functions) {
        return Arrays.stream(functions)
                    .reduce(Function.identity(), Function::compose);
    }
}
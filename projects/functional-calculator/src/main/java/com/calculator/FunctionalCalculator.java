package com.calculator;

import com.calculator.annotations.OperationMeta;
import com.calculator.history.OperationHistory;
import java.util.function.Function;
import java.util.function.BinaryOperator;
import java.util.Optional;

public class FunctionalCalculator {
    private final OperationHistory history;

    public FunctionalCalculator() {
        this.history = new OperationHistory();
    }

    @OperationMeta(name = "ADD", description = "Adds two numbers")
    public Function<Double, Double> add(Double a) {
        return b -> {
            double result = a + b;
            history.logOperation("ADD", a, b, result);
            return result;
        };
    }

    @OperationMeta(name = "SUBTRACT", description = "Subtracts two numbers")
    public Function<Double, Double> subtract(Double a) {
        return b -> {
            double result = a - b;
            history.logOperation("SUBTRACT", a, b, result);
            return result;
        };
    }

    @OperationMeta(name = "MULTIPLY", description = "Multiplies two numbers")
    public Function<Double, Double> multiply(Double a) {
        return b -> {
            double result = a * b;
            history.logOperation("MULTIPLY", a, b, result);
            return result;
        };
    }

    @OperationMeta(name = "DIVIDE", description = "Divides two numbers")
    public Function<Double, Double> divide(Double a) {
        return b -> {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            double result = a / b;
            history.logOperation("DIVIDE", a, b, result);
            return result;
        };
    }

    @OperationMeta(name = "POWER", description = "Raises a number to a power")
    public Function<Double, Double> power(Double base) {
        return exponent -> {
            double result = Math.pow(base, exponent);
            history.logOperation("POWER", base, exponent, result);
            return result;
        };
    }

    @OperationMeta(name = "SQRT", description = "Calculates square root")
    public Function<Double, Double> sqrt() {
        return a -> {
            if (a < 0) {
                throw new IllegalArgumentException("Cannot calculate square root of negative number");
            }
            double result = Math.sqrt(a);
            history.logOperation("SQRT", a, null, result);
            return result;
        };
    }

    public OperationHistory getHistory() {
        return history;
    }
}
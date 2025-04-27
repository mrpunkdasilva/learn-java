package com.calculator.history;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDateTime;

public class OperationHistory {
    private final List<OperationRecord> history = new ArrayList<>();

    public void logOperation(String operation, Double a, Double b, Double result) {
        OperationRecord record = new OperationRecord(
            operation,
            a,
            b,
            result,
            LocalDateTime.now()
        );
        history.add(record);
    }

    public List<OperationRecord> getHistory() {
        return Collections.unmodifiableList(history);
    }

    public void clear() {
        history.clear();
    }

    public record OperationRecord(
        String operation,
        Double firstOperand,
        Double secondOperand,
        Double result,
        LocalDateTime timestamp
    ) {
        @Override
        public String toString() {
            if (secondOperand == null) {
                return String.format("%s(%f) = %f", 
                    operation, firstOperand, result);
            }
            return String.format("%s: %f %s %f = %f", 
                operation, firstOperand, operation.toLowerCase(), secondOperand, result);
        }
    }
}
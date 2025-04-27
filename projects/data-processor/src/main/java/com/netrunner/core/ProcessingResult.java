package com.netrunner.core;

import java.util.ArrayList;
import java.util.List;

public class ProcessingResult<T> {
    private T processedData;
    private final List<String> errors;
    private boolean valid;

    public ProcessingResult() {
        this.errors = new ArrayList<>();
        this.valid = true;
    }

    public void addError(String error) {
        this.errors.add(error);
        this.valid = false;
    }

    public boolean isValid() {
        return valid;
    }

    public List<String> getErrors() {
        return new ArrayList<>(errors);
    }

    public T getProcessedData() {
        return processedData;
    }

    public void setProcessedData(T processedData) {
        this.processedData = processedData;
    }
}
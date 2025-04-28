package com.framework.exceptions;

public class DIException extends RuntimeException {
    public DIException(String message) {
        super(message);
    }

    public DIException(String message, Throwable cause) {
        super(message, cause);
    }
}
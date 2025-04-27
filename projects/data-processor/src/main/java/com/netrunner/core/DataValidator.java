package com.netrunner.core;

import com.netrunner.annotations.Validate;

public interface DataValidator {
    boolean validate(Object value, Validate annotation);
    String getErrorMessage();
}
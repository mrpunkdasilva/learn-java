package com.netrunner.core;

public interface DataTransformer<T> {
    T transform(T input, String... params);
}
package com.calculator.core;

@FunctionalInterface
public interface Operation<T> {
    T apply(T a, T b);
}
package com.netrunner.container;

import java.util.Optional;
import java.util.function.Function;

public class TransformingContainer<T, R> {
    private final Container<T> source;
    private final Function<T, R> transformer;
    
    public TransformingContainer(Container<T> source, Function<T, R> transformer) {
        this.source = source;
        this.transformer = transformer;
    }
    
    public Optional<R> getTransformed(int index) {
        return source.get(index).map(transformer);
    }
    
    public Optional<R> getNamedTransformed(String name) {
        return source.getNamed(name).map(transformer);
    }
}
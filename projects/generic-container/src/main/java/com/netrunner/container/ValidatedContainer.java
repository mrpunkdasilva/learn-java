package com.netrunner.container;

import java.util.function.Predicate;

public class ValidatedContainer<T> extends Container<T> {
    private final Predicate<T> validator;
    
    public ValidatedContainer(Predicate<T> validator) {
        super();
        this.validator = validator;
    }
    
    @Override
    public void add(T element) {
        if (validator.test(element)) {
            super.add(element);
        } else {
            throw new IllegalArgumentException("Invalid element");
        }
    }
    
    @Override
    public void addNamed(String name, T element) {
        if (validator.test(element)) {
            super.addNamed(name, element);
        } else {
            throw new IllegalArgumentException("Invalid element");
        }
    }
}
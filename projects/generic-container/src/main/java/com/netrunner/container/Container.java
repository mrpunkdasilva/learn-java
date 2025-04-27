package com.netrunner.container;

import java.util.*;

public class Container<T> {
    private final List<T> elements;
    private final Map<String, T> namedElements;
    
    public Container() {
        this.elements = new ArrayList<>();
        this.namedElements = new HashMap<>();
    }
    
    public void add(T element) {
        elements.add(element);
    }
    
    public void addNamed(String name, T element) {
        namedElements.put(name, element);
    }
    
    public Optional<T> get(int index) {
        return index >= 0 && index < elements.size() 
            ? Optional.of(elements.get(index))
            : Optional.empty();
    }
    
    public Optional<T> getNamed(String name) {
        return Optional.ofNullable(namedElements.get(name));
    }
    
    public List<T> getAll() {
        return Collections.unmodifiableList(elements);
    }
    
    public Map<String, T> getAllNamed() {
        return Collections.unmodifiableMap(namedElements);
    }
    
    public void remove(int index) {
        if (index >= 0 && index < elements.size()) {
            elements.remove(index);
        }
    }
    
    public void removeNamed(String name) {
        namedElements.remove(name);
    }
    
    public int size() {
        return elements.size();
    }
    
    public int namedSize() {
        return namedElements.size();
    }
}
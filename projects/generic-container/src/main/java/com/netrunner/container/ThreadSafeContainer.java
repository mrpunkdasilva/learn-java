package com.netrunner.container;

import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeContainer<T> {
    private final Container<T> container;
    private final Lock lock;
    
    public ThreadSafeContainer() {
        this.container = new Container<>();
        this.lock = new ReentrantLock();
    }
    
    public void add(T element) {
        lock.lock();
        try {
            container.add(element);
        } finally {
            lock.unlock();
        }
    }
    
    public void addNamed(String name, T element) {
        lock.lock();
        try {
            container.addNamed(name, element);
        } finally {
            lock.unlock();
        }
    }
    
    public Optional<T> get(int index) {
        lock.lock();
        try {
            return container.get(index);
        } finally {
            lock.unlock();
        }
    }
    
    public Optional<T> getNamed(String name) {
        lock.lock();
        try {
            return container.getNamed(name);
        } finally {
            lock.unlock();
        }
    }
}
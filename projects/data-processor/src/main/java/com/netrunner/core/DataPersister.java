package com.netrunner.core;

import com.netrunner.annotations.Persist;

public interface DataPersister {
    void persist(Object data, Persist annotation);
    Object retrieve(String id, Class<?> type);
}
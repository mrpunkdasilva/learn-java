package com.netrunner.reflectionexplorer.analyzer;

import com.netrunner.reflectionexplorer.annotation.Inspect;
import com.netrunner.reflectionexplorer.model.ClassInfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClassAnalyzer {
    private final Map<Class<?>, Method[]> methodCache = new ConcurrentHashMap<>();
    private final Map<Class<?>, Field[]> fieldCache = new ConcurrentHashMap<>();
    
    @Inspect
    public ClassInfo analyze(Class<?> target) {
        return ClassInfo.builder()
            .name(target.getName())
            .methods(getMethods(target))
            .fields(getFields(target))
            .annotations(target.getAnnotations())
            .superclass(target.getSuperclass())
            .interfaces(target.getInterfaces())
            .modifiers(target.getModifiers())
            .build();
    }
    
    private Method[] getMethods(Class<?> clazz) {
        return methodCache.computeIfAbsent(clazz, Class::getDeclaredMethods);
    }
    
    private Field[] getFields(Class<?> clazz) {
        return fieldCache.computeIfAbsent(clazz, Class::getDeclaredFields);
    }
}
package com.netrunner.reflectionexplorer.analyzer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DependencyAnalyzer {
    public Set<Class<?>> findDependencies(Class<?> targetClass) {
        Set<Class<?>> dependencies = new HashSet<>();
        
        // Analisa campos
        for (Field field : targetClass.getDeclaredFields()) {
            dependencies.add(field.getType());
        }
        
        // Analisa métodos
        for (Method method : targetClass.getDeclaredMethods()) {
            dependencies.addAll(Arrays.asList(method.getParameterTypes()));
            dependencies.add(method.getReturnType());
        }
        
        return dependencies;
    }
    
    public Set<Class<?>> findRecursiveDependencies(Class<?> targetClass) {
        Set<Class<?>> visited = new HashSet<>();
        findDependenciesRecursive(targetClass, visited);
        return visited;
    }
    
    private void findDependenciesRecursive(Class<?> clazz, Set<Class<?>> visited) {
        if (clazz == null || visited.contains(clazz)) {
            return;
        }
        
        visited.add(clazz);
        Set<Class<?>> directDependencies = findDependencies(clazz);
        
        for (Class<?> dependency : directDependencies) {
            findDependenciesRecursive(dependency, visited);
        }
    }
}
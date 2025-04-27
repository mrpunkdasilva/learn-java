package com.netrunner.reflectionexplorer.cache;

import com.netrunner.reflectionexplorer.analyzer.ClassAnalyzer;
import com.netrunner.reflectionexplorer.model.ClassInfo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectionCache {
    private static final Map<Class<?>, ClassInfo> CLASS_INFO_CACHE = 
        new ConcurrentHashMap<>();
    
    public static ClassInfo getClassInfo(Class<?> clazz) {
        return CLASS_INFO_CACHE.computeIfAbsent(
            clazz,
            ReflectionCache::analyzeClass
        );
    }
    
    private static ClassInfo analyzeClass(Class<?> clazz) {
        return new ClassAnalyzer().analyze(clazz);
    }
    
    public static void clearCache() {
        CLASS_INFO_CACHE.clear();
    }
}
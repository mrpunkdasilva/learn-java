package com.netrunner.reflectionexplorer.core;

import com.netrunner.reflectionexplorer.analyzer.ClassAnalyzer;
import com.netrunner.reflectionexplorer.model.ClassInfo;
import com.netrunner.reflectionexplorer.modifier.ObjectModifier;
import com.netrunner.reflectionexplorer.proxy.ProxyGenerator;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationHandler;

@RequiredArgsConstructor
public class ReflectionExplorer {
    private final ClassAnalyzer analyzer;
    private final ObjectModifier modifier;
    private final ProxyGenerator proxyGen;

    public ClassInfo analyze(Class<?> clazz) {
        return analyzer.analyze(clazz);
    }

    public Object modify(Object instance, Enhancement enhancement) {
        return modifier.enhance(instance, enhancement);
    }

    public <T> T createProxy(Class<T> interfaceType, InvocationHandler handler) {
        return proxyGen.createProxy(interfaceType, handler);
    }
}
package com.netrunner.reflectionexplorer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyGenerator {
    public <T> T createProxy(
        Class<T> interfaceType,
        InvocationHandler handler
    ) {
        return (T) Proxy.newProxyInstance(
            interfaceType.getClassLoader(),
            new Class<?>[] { interfaceType },
            handler
        );
    }
    
    public static class LoggingHandler implements InvocationHandler {
        private final Object target;
        
        public LoggingHandler(Object target) {
            this.target = target;
        }
        
        @Override
        public Object invoke(
            Object proxy,
            Method method,
            Object[] args
        ) throws Throwable {
            System.out.println("Before: " + method.getName());
            Object result = method.invoke(target, args);
            System.out.println("After: " + method.getName());
            return result;
        }
    }
}
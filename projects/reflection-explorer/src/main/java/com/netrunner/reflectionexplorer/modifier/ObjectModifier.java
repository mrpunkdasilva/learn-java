package com.netrunner.reflectionexplorer.modifier;

import com.netrunner.reflectionexplorer.annotation.Modify;
import com.netrunner.reflectionexplorer.annotation.Target;
import com.netrunner.reflectionexplorer.model.Enhancement;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectModifier {
    @Modify
    public Object enhance(
        @Target Object instance,
        Enhancement enhancement
    ) {
        try {
            Class<?> clazz = instance.getClass();
            
            for (Field field : clazz.getDeclaredFields()) {
                if (enhancement.shouldModify(field)) {
                    field.setAccessible(true);
                    field.set(instance, enhancement.getNewValue(field));
                }
            }
            
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to enhance object", e);
        }
    }
    
    public Object interceptMethod(
        Object instance,
        Method method,
        Object[] args,
        MethodHandler handler
    ) throws Exception {
        handler.beforeInvocation(method, args);
        Object result = method.invoke(instance, args);
        return handler.afterInvocation(method, result);
    }
}
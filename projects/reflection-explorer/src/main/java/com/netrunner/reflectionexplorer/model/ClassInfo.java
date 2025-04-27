package com.netrunner.reflectionexplorer.model;

import lombok.Builder;
import lombok.Data;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Data
@Builder
public class ClassInfo {
    private String name;
    private Method[] methods;
    private Field[] fields;
    private Annotation[] annotations;
    private Class<?> superclass;
    private Class<?>[] interfaces;
    private int modifiers;
}
package com.netrunner.example;

import com.netrunner.annotations.ValidateAnnotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ValidateAnnotation
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Route {
    String path();
    String method() default "GET";
}
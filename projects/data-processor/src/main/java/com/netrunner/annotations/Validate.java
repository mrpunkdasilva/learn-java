package com.netrunner.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Validate {
    String pattern() default "";
    boolean required() default true;
    int minLength() default 0;
    int maxLength() default Integer.MAX_VALUE;
    String message() default "";
}
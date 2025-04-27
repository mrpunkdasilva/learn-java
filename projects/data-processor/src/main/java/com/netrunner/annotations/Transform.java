package com.netrunner.annotations;

import com.netrunner.core.DataTransformer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Transform {
    Class<? extends DataTransformer<?>> transformer();
    String[] params() default {};
}
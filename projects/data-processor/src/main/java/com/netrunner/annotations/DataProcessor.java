package com.netrunner.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DataProcessor {
    String value() default "";
    String version() default "1.0";
    ProcessingMode mode() default ProcessingMode.SYNC;
    
    public enum ProcessingMode {
        SYNC, ASYNC, BATCH
    }
}
package com.netrunner.engine;

import com.netrunner.annotations.DataProcessor;
import com.netrunner.annotations.Persist;
import com.netrunner.annotations.Transform;
import com.netrunner.annotations.Validate;
import com.netrunner.core.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DataProcessorEngine {
    private final Map<Class<?>, DataValidator> validators;
    private final Map<Class<?>, DataTransformer<?>> transformers;
    private final Map<String, DataPersister> persisters;

    public DataProcessorEngine() {
        this.validators = new HashMap<>();
        this.transformers = new HashMap<>();
        this.persisters = new HashMap<>();
    }

    public <T> ProcessingResult<T> process(T data) {
        Class<?> dataClass = data.getClass();
        
        if (!dataClass.isAnnotationPresent(DataProcessor.class)) {
            throw new IllegalArgumentException("Class not annotated with @DataProcessor");
        }

        ProcessingResult<T> result = new ProcessingResult<>();
        
        validateFields(data, result);
        
        if (!result.isValid()) {
            return result;
        }

        T transformed = transformFields(data);
        persistFields(transformed);

        result.setProcessedData(transformed);
        return result;
    }

    @SuppressWarnings("unchecked")
    private <T> void validateFields(T data, ProcessingResult<T> result) {
        for (Field field : data.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Validate.class)) {
                field.setAccessible(true);
                try {
                    Object value = field.get(data);
                    Validate annotation = field.getAnnotation(Validate.class);
                    DataValidator validator = validators.get(field.getType());
                    
                    if (validator != null && !validator.validate(value, annotation)) {
                        result.addError(validator.getErrorMessage());
                    }
                } catch (IllegalAccessException e) {
                    result.addError("Cannot access field: " + field.getName());
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private <T> T transformFields(T data) {
        try {
            T copy = (T) data.getClass().getDeclaredConstructor().newInstance();
            
            for (Field field : data.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(Transform.class)) {
                    Transform annotation = field.getAnnotation(Transform.class);
                    DataTransformer transformer = transformers.get(field.getType());
                    
                    if (transformer != null) {
                        Object originalValue = field.get(data);
                        Object transformedValue = transformer.transform(
                            originalValue, 
                            annotation.params()
                        );
                        field.set(copy, transformedValue);
                    }
                } else {
                    field.set(copy, field.get(data));
                }
            }
            return copy;
        } catch (Exception e) {
            throw new RuntimeException("Error during transformation", e);
        }
    }

    private <T> void persistFields(T data) {
        for (Field field : data.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Persist.class)) {
                try {
                    Persist annotation = field.getAnnotation(Persist.class);
                    DataPersister persister = persisters.get(annotation.strategy());
                    
                    if (persister != null) {
                        persister.persist(field.get(data), annotation);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error during persistence", e);
                }
            }
        }
    }

    public void registerValidator(Class<?> type, DataValidator validator) {
        validators.put(type, validator);
    }

    public void registerTransformer(Class<?> type, DataTransformer<?> transformer) {
        transformers.put(type, transformer);
    }

    public void registerPersister(String strategy, DataPersister persister) {
        persisters.put(strategy, persister);
    }
}
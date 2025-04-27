package com.framework.core;

import com.framework.annotations.Component;
import com.framework.annotations.Inject;
import com.framework.annotations.Initialize;
import com.framework.exceptions.DIException;

import java.lang.reflect.*;
import java.util.*;

public class DIContainer {
    private final Map<Class<?>, Object> singletons = new HashMap<>();
    private final Map<Class<?>, Class<?>> bindings = new HashMap<>();
    private final Set<Class<?>> beingConstructed = new HashSet<>();

    public <T> void bind(Class<T> interfaceClass, Class<? extends T> implementationClass) {
        if (!interfaceClass.isInterface() && !Modifier.isAbstract(interfaceClass.getModifiers())) {
            throw new DIException("First argument must be an interface or abstract class");
        }
        bindings.put(interfaceClass, implementationClass);
    }

    public <T> T getInstance(Class<T> type) {
        // Verifica se já existe singleton
        if (singletons.containsKey(type)) {
            return (T) singletons.get(type);
        }

        // Verifica se existe binding
        Class<?> implementationType = bindings.getOrDefault(type, type);

        // Verifica ciclo de dependências
        if (beingConstructed.contains(implementationType)) {
            throw new DIException("Circular dependency detected for type: " + type.getName());
        }

        try {
            beingConstructed.add(implementationType);
            T instance = createInstance(implementationType);

            // Se for singleton, armazena a instância
            if (isSingleton(implementationType)) {
                singletons.put(type, instance);
            }

            return instance;
        } finally {
            beingConstructed.remove(implementationType);
        }
    }

    private <T> T createInstance(Class<?> type) {
        try {
            // Procura construtor com @Inject
            Constructor<?>[] constructors = type.getDeclaredConstructors();
            Constructor<?> constructor = findInjectableConstructor(constructors);

            // Se não encontrar, usa o construtor padrão
            if (constructor == null) {
                constructor = type.getDeclaredConstructor();
            }

            constructor.setAccessible(true);

            // Cria instância com dependências do construtor
            Object[] dependencies = getDependencies(constructor.getParameters());
            T instance = (T) constructor.newInstance(dependencies);

            // Injeta dependências nos campos
            injectFields(instance);

            // Inicializa métodos com @Initialize
            initializeMethods(instance);

            return instance;
        } catch (Exception e) {
            throw new DIException("Error creating instance of " + type.getName(), e);
        }
    }

    private Constructor<?> findInjectableConstructor(Constructor<?>[] constructors) {
        Constructor<?> injectConstructor = null;
        for (Constructor<?> constructor : constructors) {
            if (constructor.isAnnotationPresent(Inject.class)) {
                if (injectConstructor != null) {
                    throw new DIException("Multiple injectable constructors found");
                }
                injectConstructor = constructor;
            }
        }
        return injectConstructor;
    }

    private Object[] getDependencies(Parameter[] parameters) {
        Object[] dependencies = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            dependencies[i] = getInstance(parameters[i].getType());
        }
        return dependencies;
    }

    private void injectFields(Object instance) {
        Class<?> type = instance.getClass();
        while (type != null) {
            for (Field field : type.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);
                    try {
                        Object dependency = getInstance(field.getType());
                        field.set(instance, dependency);
                    } catch (Exception e) {
                        throw new DIException("Error injecting field " + field.getName(), e);
                    }
                }
            }
            type = type.getSuperclass();
        }
    }

    private void initializeMethods(Object instance) {
        Class<?> type = instance.getClass();
        List<Method> initMethods = new ArrayList<>();

        // Coleta todos os métodos com @Initialize
        while (type != null) {
            for (Method method : type.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Initialize.class)) {
                    initMethods.add(method);
                }
            }
            type = type.getSuperclass();
        }

        // Ordena por order()
        initMethods.sort((m1, m2) -> {
            Initialize i1 = m1.getAnnotation(Initialize.class);
            Initialize i2 = m2.getAnnotation(Initialize.class);
            return Integer.compare(i1.order(), i2.order());
        });

        // Executa os métodos
        for (Method method : initMethods) {
            try {
                method.setAccessible(true);
                method.invoke(instance);
            } catch (Exception e) {
                throw new DIException("Error initializing method " + method.getName(), e);
            }
        }
    }

    private boolean isSingleton(Class<?> type) {
        Component component = type.getAnnotation(Component.class);
        return component == null || "singleton".equals(component.scope());
    }
}
# Reflection API

## Fundamentos

### O que é Reflection?
Reflection é a capacidade de examinar e modificar o comportamento de classes, interfaces e métodos em tempo de execução.

## Principais Componentes

### Class<?>
```java
// Obtendo Class object
Class<?> clazz = MyClass.class;
Class<?> clazz = objeto.getClass();
Class<?> clazz = Class.forName("com.example.MyClass");
```

### Métodos
```java
// Acessando métodos
Method[] methods = clazz.getDeclaredMethods();
Method method = clazz.getDeclaredMethod("methodName", parameterTypes);
```

### Campos
```java
// Acessando campos
Field[] fields = clazz.getDeclaredFields();
Field field = clazz.getDeclaredField("fieldName");
```

## Casos de Uso

### Inspeção de Classes
```java
public void inspectClass(Class<?> clazz) {
    System.out.println("Class: " + clazz.getName());
    System.out.println("Superclass: " + clazz.getSuperclass().getName());
    System.out.println("Interfaces: " + Arrays.toString(clazz.getInterfaces()));
}
```

### Manipulação de Objetos
```java
public Object createInstance(String className) throws Exception {
    Class<?> clazz = Class.forName(className);
    return clazz.getDeclaredConstructor().newInstance();
}
```

## Recursos Avançados

### Anotações
```java
// Lendo anotações
Annotation[] annotations = clazz.getAnnotations();
MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
```

### Generics
```java
// Trabalhando com tipos genéricos
Type[] genericTypes = ((ParameterizedType) field.getGenericType())
    .getActualTypeArguments();
```

## Boas Práticas

### Performance
- Cache de reflection
- Minimizar uso em loops
- Preferir acesso direto quando possível

### Segurança
- Usar setAccessible com cautela
- Validar entrada do usuário
- Considerar políticas de segurança

## Exemplos Práticos

### Framework de Teste
```java
public class TestRunner {
    public void runTests(Class<?> testClass) throws Exception {
        Object instance = testClass.getDeclaredConstructor().newInstance();
        
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                method.invoke(instance);
            }
        }
    }
}
```

### Injeção de Dependência
```java
public class DependencyInjector {
    public void inject(Object instance) throws Exception {
        Class<?> clazz = instance.getClass();
        
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(instance, createDependency(field.getType()));
            }
        }
    }
}
```

## Debugging e Troubleshooting

### Erros Comuns
1. IllegalAccessException
2. NoSuchMethodException
3. InvocationTargetException

### Soluções
```java
// Tratamento de exceções
try {
    method.setAccessible(true);
    method.invoke(object, args);
} catch (Exception e) {
    handleReflectionException(e);
}
```

## Performance

### Otimizações
```java
// Cache de reflection
private static final Map<Class<?>, Method[]> methodCache = new ConcurrentHashMap<>();

public Method[] getMethods(Class<?> clazz) {
    return methodCache.computeIfAbsent(clazz, Class::getDeclaredMethods);
}
```

## Recursos Adicionais

### Documentação
- Java Reflection API Documentation
- Tutorial Oracle sobre Reflection
- Especificação da linguagem Java

### Ferramentas
- ByteBuddy
- Reflections Library
- ASM
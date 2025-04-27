# Generic Container

![Generic Container](generic-container-banner.png)
{style="width:700px"}

## Visão Geral
Um container genérico é uma estrutura de dados flexível que pode armazenar e gerenciar diferentes tipos de objetos de forma type-safe.

## Estrutura Base

### Container Genérico Básico
```java
public class Container<T> {
    private final List<T> elements;
    private final Map<String, T> namedElements;
    
    public Container() {
        this.elements = new ArrayList<>();
        this.namedElements = new HashMap<>();
    }
    
    public void add(T element) {
        elements.add(element);
    }
    
    public void addNamed(String name, T element) {
        namedElements.put(name, element);
    }
    
    public Optional<T> get(int index) {
        return index >= 0 && index < elements.size() 
            ? Optional.of(elements.get(index))
            : Optional.empty();
    }
    
    public Optional<T> getNamed(String name) {
        return Optional.ofNullable(namedElements.get(name));
    }
}
```

## Funcionalidades Avançadas

### Container com Validação
```java
public class ValidatedContainer<T> extends Container<T> {
    private final Predicate<T> validator;
    
    public ValidatedContainer(Predicate<T> validator) {
        super();
        this.validator = validator;
    }
    
    @Override
    public void add(T element) {
        if (validator.test(element)) {
            super.add(element);
        } else {
            throw new IllegalArgumentException("Elemento inválido");
        }
    }
}
```

### Container com Transformação
```java
public class TransformingContainer<T, R> {
    private final Container<T> source;
    private final Function<T, R> transformer;
    
    public TransformingContainer(Container<T> source, Function<T, R> transformer) {
        this.source = source;
        this.transformer = transformer;
    }
    
    public Optional<R> getTransformed(int index) {
        return source.get(index).map(transformer);
    }
}
```

## Casos de Uso

### Gerenciamento de Dados
```java
Container<User> userContainer = new Container<>();
userContainer.add(new User("Alice"));
userContainer.addNamed("admin", new User("Admin"));

ValidatedContainer<Email> emailContainer = 
    new ValidatedContainer<>(Email::isValid);
emailContainer.add(new Email("user@example.com"));
```

### Processamento de Dados
```java
Container<String> stringContainer = new Container<>();
stringContainer.add("123");
stringContainer.add("456");

TransformingContainer<String, Integer> numberContainer =
    new TransformingContainer<>(stringContainer, Integer::parseInt);

Optional<Integer> number = numberContainer.getTransformed(0); // 123
```

## Boas Práticas

1. **Type Safety**
   - Use bounds quando necessário
   - Evite type erasure quando possível
   - Valide tipos em runtime quando apropriado

2. **Performance**
   - Implemente lazy loading
   - Use estruturas de dados apropriadas
   - Considere cache para operações custosas

3. **Thread Safety**
```java
public class ThreadSafeContainer<T> {
    private final Container<T> container;
    private final Lock lock;
    
    public ThreadSafeContainer() {
        this.container = new Container<>();
        this.lock = new ReentrantLock();
    }
    
    public void add(T element) {
        lock.lock();
        try {
            container.add(element);
        } finally {
            lock.unlock();
        }
    }
}
```

## Exercícios Propostos

1. Implemente um container com suporte a eventos (Observer pattern)
2. Crie um container com política de expiração de elementos
3. Desenvolva um container com suporte a operações em batch
4. Adicione funcionalidade de serialização/deserialização

## Próximos Passos
- Explorar integração com Streams API
- Implementar padrões de design adicionais
- Adicionar suporte a persistência
- Desenvolver visualizações de dados

[Annotation Processor](annotation-processor.md){.next-step}
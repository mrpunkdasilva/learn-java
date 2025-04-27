# Optional: Tratamento Elegante de Null

```ascii
OPTIONAL API
├── Creation
├── Checking
├── Extraction
└── Transformation
```

## Criando Optionals

### Métodos de Criação
```java
// Valor presente
Optional<String> present = Optional.of("Neo");

// Possivelmente null
Optional<String> nullable = Optional.ofNullable(getValue());

// Definitivamente vazio
Optional<String> empty = Optional.empty();
```

## Verificando Valores

### Métodos de Verificação
```java
Optional<String> opt = Optional.of("Trinity");

// Verifica se há valor
boolean hasValue = opt.isPresent();

// Verifica se está vazio
boolean isEmpty = opt.isEmpty(); // Java 11+
```

## Extraindo Valores

### Métodos de Extração
```java
String value = opt.get(); // Pode lançar NoSuchElementException

// Com valor padrão
String safe = opt.orElse("Default");

// Com supplier
String computed = opt.orElseGet(() -> computeDefault());

// Com exceção
String required = opt.orElseThrow(
    () -> new IllegalStateException("Valor requerido")
);
```

## Transformando Valores

### Map e FlatMap
```java
Optional<String> upper = opt.map(String::toUpperCase);

Optional<Optional<String>> nested = 
    Optional.of(Optional.of("Nested"));
Optional<String> flat = nested.flatMap(o -> o);
```

## Padrões de Uso

### Encadeamento
```java
public class UserService {
    public Optional<String> getEmail(String userId) {
        return findUser(userId)
            .map(User::getProfile)
            .map(Profile::getEmail);
    }
}
```

### Consumindo Valores
```java
opt.ifPresent(value -> System.out.println(value));

// Com ação alternativa (Java 9+)
opt.ifPresentOrElse(
    value -> System.out.println(value),
    () -> System.out.println("Vazio")
);
```

## Boas Práticas

1. **Evite Optional.get()**
```java
// Ruim
String value = optional.get();

// Bom
String value = optional.orElse("default");
```

2. **Não use Optional como Parâmetro**
```java
// Ruim
public void process(Optional<String> value) {}

// Bom
public void process(String value) {}
```

3. **Use para Retornos**
```java
public Optional<User> findUser(String id) {
    User user = database.query(id);
    return Optional.ofNullable(user);
}
```

## Exemplo Prático

### Sistema de Configuração
```java
public class Config {
    private Map<String, String> settings;

    public Optional<String> getSetting(String key) {
        return Optional.ofNullable(settings.get(key));
    }

    public String getSettingWithDefault(String key) {
        return getSetting(key)
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .orElse("default");
    }
}
```

## Exercício

Implemente um sistema de cache com Optional:
```java
public class Cache<K, V> {
    private Map<K, V> storage = new HashMap<>();

    public Optional<V> get(K key) {
        return Optional.ofNullable(storage.get(key));
    }

    public V getOrCompute(K key, Supplier<V> computer) {
        return get(key)
            .orElseGet(() -> {
                V value = computer.get();
                storage.put(key, value);
                return value;
            });
    }
}
```
# Expressões Lambda: Programação Funcional em Java

```ascii
LAMBDA CONCEPTS
├── Syntax
├── Functional Interfaces
├── Method References
└── Common Use Cases
```

## Sintaxe Básica

### Forma Padrão
```java
// Sintaxe: (parâmetros) -> { corpo }
Runnable r = () -> { System.out.println("Executando"); };

// Versão simplificada
Comparator<String> c = (s1, s2) -> s1.length() - s2.length();
```

## Interfaces Funcionais Comuns

### Function<T,R>
```java
Function<String, Integer> length = str -> str.length();
Integer size = length.apply("NetRunner");
```

### Predicate<T>
```java
Predicate<String> isEmpty = str -> str.trim().isEmpty();
boolean result = isEmpty.test("  ");
```

### Consumer<T>
```java
Consumer<String> print = msg -> System.out.println(msg);
print.accept("Hello, Runner!");
```

### Supplier<T>
```java
Supplier<LocalDateTime> now = () -> LocalDateTime.now();
LocalDateTime time = now.get();
```

## Method References

### Tipos de References
```java
// Referência a método estático
Function<String, Integer> parser = Integer::parseInt;

// Referência a método de instância
String str = "NetRunner";
Supplier<Integer> length = str::length;

// Referência a construtor
Supplier<ArrayList<String>> constructor = ArrayList::new;
```

## Composição de Funções

### Combining Functions
```java
Function<String, String> upper = String::toUpperCase;
Function<String, String> trim = String::trim;
Function<String, String> combined = upper.andThen(trim);
```

## Exemplo Prático

### Stream com Lambda
```java
List<String> hackers = Arrays.asList("Neo", "Trinity", "Morpheus");

hackers.stream()
    .filter(name -> name.length() > 3)
    .map(String::toUpperCase)
    .forEach(System.out::println);
```

## Boas Práticas

1. **Mantenha Lambdas Simples**
```java
// Ruim
button.setOnAction(e -> {
    // 20 linhas de código aqui
});

// Bom
button.setOnAction(this::handleClick);
```

2. **Use Method References**
```java
// Menos legível
list.forEach(item -> System.out.println(item));

// Mais legível
list.forEach(System.out::println);
```

## Exercício

Implemente um sistema de filtro usando lambdas:
```java
public class HackerFilter {
    public static List<Hacker> filterBySkill(
        List<Hacker> hackers,
        Predicate<Hacker> criteria
    ) {
        return hackers.stream()
                     .filter(criteria)
                     .collect(Collectors.toList());
    }
}

// Uso
List<Hacker> eliteHackers = filterBySkill(
    hackerList,
    h -> h.getSkillLevel() > 9000
);
```
# Streams API: Processamento de Dados Fluente

```ascii
STREAMS API
├── Creation
├── Intermediate Ops
├── Terminal Ops
└── Parallel Streams
```

## Criando Streams

### Métodos de Criação
```java
// De Collection
List<String> list = Arrays.asList("Neo", "Trinity");
Stream<String> stream = list.stream();

// Stream direto
Stream<String> direct = Stream.of("Morpheus", "Tank");

// Stream infinito
Stream<Integer> infinite = Stream.iterate(0, n -> n + 1);
```

## Operações Intermediárias

### Filter
```java
List<String> hackers = Arrays.asList("Neo", "Trinity", "Morpheus");
hackers.stream()
      .filter(name -> name.length() > 3)
      .collect(Collectors.toList());
```

### Map
```java
List<Integer> lengths = hackers.stream()
    .map(String::length)
    .collect(Collectors.toList());
```

### FlatMap
```java
List<List<String>> nested = Arrays.asList(
    Arrays.asList("Neo", "Trinity"),
    Arrays.asList("Morpheus", "Tank")
);

List<String> flat = nested.stream()
    .flatMap(List::stream)
    .collect(Collectors.toList());
```

## Operações Terminais

### Collect
```java
// Para Lista
List<String> list = stream.collect(Collectors.toList());

// Para Set
Set<String> set = stream.collect(Collectors.toSet());

// Para Map
Map<String, Integer> map = stream.collect(
    Collectors.toMap(
        s -> s,
        String::length
    )
);
```

### Reduce
```java
Optional<Integer> sum = Stream.of(1, 2, 3)
    .reduce((a, b) -> a + b);

int total = Stream.of(1, 2, 3)
    .reduce(0, Integer::sum);
```

## Streams Paralelos

### Processamento Paralelo
```java
// Stream paralelo de Collection
List<String> result = hackers.parallelStream()
    .filter(name -> name.length() > 3)
    .collect(Collectors.toList());

// Converter para paralelo
Stream<String> parallel = stream.parallel();
```

## Exemplos Práticos

### Análise de Dados
```java
class HackerStats {
    public static Map<String, Long> analyzeSkills(List<Hacker> hackers) {
        return hackers.stream()
            .flatMap(h -> h.getSkills().stream())
            .collect(Collectors.groupingBy(
                skill -> skill,
                Collectors.counting()
            ));
    }
}
```

### Pipeline Complexo
```java
List<Hacker> eliteSquad = hackers.stream()
    .filter(h -> h.getLevel() > 50)
    .sorted(Comparator.comparing(Hacker::getSkillLevel).reversed())
    .limit(5)
    .collect(Collectors.toList());
```

## Boas Práticas

1. **Use Parallel com Cautela**
```java
// Nem sempre mais rápido!
boolean anyMatch = hugeList.parallelStream()
    .anyMatch(predicate);
```

2. **Evite Estado Mutável**
```java
// Ruim
List<String> results = new ArrayList<>();
stream.forEach(results::add);

// Bom
List<String> results = stream.collect(Collectors.toList());
```

## Exercício

Implemente um sistema de análise de logs:
```java
public class LogAnalyzer {
    public static Map<String, Long> analyzeErrors(
        List<LogEntry> logs
    ) {
        return logs.stream()
            .filter(log -> log.getLevel() == Level.ERROR)
            .collect(Collectors.groupingBy(
                LogEntry::getErrorCode,
                Collectors.counting()
            ));
    }
}
```
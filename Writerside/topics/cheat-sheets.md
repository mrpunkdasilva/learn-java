# Cheat Sheets

## Sintaxe Básica
```java
// Declarações
int numero = 10;
String texto = "Hello";
final double PI = 3.14;

// Controle de fluxo
if (condicao) {
    // código
} else {
    // código
}

for (int i = 0; i < 10; i++) {
    // código
}
```

## Collections Framework
```java
// List
List<String> lista = new ArrayList<>();
lista.add("item");

// Map
Map<String, Integer> mapa = new HashMap<>();
mapa.put("chave", 1);

// Set
Set<Integer> conjunto = new HashSet<>();
conjunto.add(1);
```

## Lambda Expressions
```java
// Básico
Runnable r = () -> System.out.println("Hello");

// Com parâmetros
Consumer<String> c = (s) -> System.out.println(s);

// Com múltiplas linhas
Comparator<String> comp = (s1, s2) -> {
    if (s1 == null) return -1;
    if (s2 == null) return 1;
    return s1.compareTo(s2);
};
```

## Stream API
```java
// Operações comuns
list.stream()
    .filter(x -> x > 0)
    .map(x -> x * 2)
    .collect(Collectors.toList());

// Redução
int sum = numbers.stream()
    .reduce(0, Integer::sum);
```

## Optional
```java
// Criação
Optional<String> opt = Optional.of("value");
Optional<String> empty = Optional.empty();

// Uso
String value = opt.orElse("default");
opt.ifPresent(System.out::println);
```

## Files e I/O
```java
// Leitura
List<String> lines = Files.readAllLines(Path.of("file.txt"));

// Escrita
Files.write(Path.of("output.txt"), content.getBytes());

// Try-with-resources
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    // código
}
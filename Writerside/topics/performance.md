# Performance

## Otimização de Strings

### Concatenação
```java
// Má prática
String result = "";
for (int i = 0; i < 1000; i++) {
    result += "Data";  // Cria nova String a cada iteração
}

// Boa prática
StringBuilder builder = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    builder.append("Data");  // Reutiliza o mesmo objeto
}
String result = builder.toString();
```

## Escolha de Implementação

### Comparação de Performance
```java
// StringBuffer: Thread-safe, mais lento
public class ThreadSafeLogger {
    private StringBuffer buffer = new StringBuffer();
    
    public synchronized void log(String message) {
        buffer.append(message).append("\n");
    }
}

// StringBuilder: Não thread-safe, mais rápido
public class FastLogger {
    private StringBuilder builder = new StringBuilder();
    
    public void log(String message) {
        builder.append(message).append("\n");
    }
}
```

## Gerenciamento de Memória

### Capacidade Inicial
```java
// Pré-alocação eficiente
StringBuilder optimized = new StringBuilder(1000);  // Capacidade conhecida
StringBuffer predicted = new StringBuffer(500);     // Evita realocações

// Ajuste dinâmico
StringBuilder dynamic = new StringBuilder();
dynamic.ensureCapacity(calculateNeededCapacity());  // Ajusta conforme necessário
```

## Técnicas de Otimização

### Cache de Strings
```java
// Cache de strings frequentes
public class StringCache {
    private static final Map<String, String> cache = new HashMap<>();
    
    public static String get(String key) {
        return cache.computeIfAbsent(key, k -> 
            new StringBuilder()
                .append("Prefix-")
                .append(k)
                .append("-Suffix")
                .toString()
        );
    }
}
```

### Pool de Strings
```java
// Uso do pool de strings
String pooled = "constant";           // Vai para o pool
String dynamic = new String("new");   // Não vai para o pool
String intern = dynamic.intern();     // Força entrada no pool
```

## Medição de Performance

### Benchmarking
```java
public class StringPerformanceTest {
    public static void benchmark() {
        long start = System.nanoTime();
        
        // Teste com StringBuilder
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100_000; i++) {
            builder.append("x");
        }
        
        long builderTime = System.nanoTime() - start;
        System.out.printf("StringBuilder: %,d ns%n", builderTime);
        
        // Teste com concatenação
        start = System.nanoTime();
        String concat = "";
        for (int i = 0; i < 100_000; i++) {
            concat += "x";
        }
        
        long concatTime = System.nanoTime() - start;
        System.out.printf("Concatenação: %,d ns%n", concatTime);
    }
}
```

## Boas Práticas

### Recomendações
```java
// Escolha correta de implementação
public class StringProcessor {
    // Para operações thread-safe
    private StringBuffer threadSafe = new StringBuffer();
    
    // Para operações locais
    public String process(String input) {
        StringBuilder local = new StringBuilder(input.length() + 100);
        return local.append(input)
                   .append("-processed")
                   .toString();
    }
    
    // Para strings imutáveis
    private static final String CONSTANT = "fixed-value";
}
```

## Armadilhas Comuns

### Problemas a Evitar
```java
// Evite concatenação em loops
for (String item : items) {
    // Ruim
    result += item;
    
    // Bom
    builder.append(item);
}

// Evite criar builders desnecessários
StringBuilder temp = new StringBuilder();  // Ruim se usado uma vez
temp.append("one-time-use").toString();
```

## Próximos Passos

### Tópicos Relacionados
- [Profiling](profiling.md)
- [Otimização de Código](code-optimization.md)
- [JVM Tuning](jvm-tuning.md)

[Profiling](profiling.md){.next-step}
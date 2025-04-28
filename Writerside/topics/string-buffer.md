# StringBuffer

## Conceitos Básicos

### Criação
```java
// Inicialização
StringBuffer buffer = new StringBuffer();
StringBuffer preset = new StringBuffer("INIT:");
StringBuffer sized = new StringBuffer(32);
```

## Características Principais

### Thread Safety
```java
// StringBuffer é thread-safe
public class SafeLogger {
    private StringBuffer log = new StringBuffer();
    
    public synchronized void addEntry(String entry) {
        log.append("[")
           .append(System.currentTimeMillis())
           .append("] ")
           .append(entry)
           .append("\n");
    }
}
```

## Comparação com StringBuilder

### Diferenças Chave
```java
// StringBuffer: Thread-safe, mais lento
StringBuffer safeBuffer = new StringBuffer();
synchronized(safeBuffer) {
    safeBuffer.append("Thread Safe");
}

// StringBuilder: Não thread-safe, mais rápido
StringBuilder fastBuilder = new StringBuilder();
fastBuilder.append("Fast");  // Sem sincronização
```

## Operações Básicas

### Manipulação
```java
StringBuffer message = new StringBuffer();

// Adição
message.append("STATUS: ")     // Concatenação
      .append("ACTIVE")       // Encadeamento
      .append(" - ")
      .append(2077);

// Inserção
message.insert(0, "[MSG] ");  // Início
message.insert(6, "URGENT "); // Meio

// Remoção
message.delete(0, 5);         // Range
message.deleteCharAt(10);     // Caractere único
```

## Performance

### Considerações
```java
// Escolha baseada no contexto
public class MessageProcessor {
    // Use StringBuffer para contextos multi-thread
    private StringBuffer sharedBuffer = new StringBuffer();
    
    // Use StringBuilder para operações locais
    public String processLocal() {
        StringBuilder local = new StringBuilder();
        return local.append("Local").toString();
    }
}
```

## Métodos Úteis

### Funcionalidades
```java
StringBuffer cmd = new StringBuffer("EXECUTE");

// Capacidade
int cap = cmd.capacity();     // Capacidade atual
cmd.ensureCapacity(100);      // Garante capacidade mínima

// Modificação
cmd.setCharAt(0, 'e');       // Modifica caractere
cmd.setLength(4);            // Trunca ou expande
cmd.replace(0, 2, "RE");     // Substitui range

// Reversão
cmd.reverse();               // Inverte conteúdo
```

## Boas Práticas

### Recomendações
```java
// Use StringBuffer quando:
public class SharedResource {
    private StringBuffer sharedLog;  // Múltiplas threads
    
    public void logEvent(String event) {
        synchronized(sharedLog) {
            sharedLog.append(event)
                    .append("\n");
        }
    }
}

// Prefira StringBuilder quando:
public String formatLocal() {
    StringBuilder local = new StringBuilder();  // Single thread
    return local.append("Local")
               .append("Format")
               .toString();
}
```

## Próximos Passos

### Tópicos Relacionados
- [StringBuilder](string-builder.md)
- [Concorrência](concurrency.md)
- [Performance](performance.md)

[StringBuilder](string-builder.md){.next-step}
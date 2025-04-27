# StringBuilder

## Conceitos Básicos

### Criação
```java
// Inicialização
StringBuilder buffer = new StringBuilder();
StringBuilder preset = new StringBuilder("INIT:");
StringBuilder sized = new StringBuilder(32);
```

## Operações Principais

### Manipulação
```java
StringBuilder log = new StringBuilder();

// Adição
log.append("STATUS: ")    // Concatenação
   .append("ONLINE")      // Encadeamento
   .append(" - ")
   .append(2077);

// Inserção
log.insert(0, "[LOG] ");  // Início
log.insert(6, "DEBUG ");  // Meio

// Remoção
log.delete(0, 5);         // Range
log.deleteCharAt(10);     // Caractere único

// Reversão
log.reverse();            // Inverte a string
```

## Performance

### Comparação com String
```java
// Má prática (String)
String result = "";
for (int i = 0; i < 1000; i++) {
    result += "Data";  // Cria nova String cada vez
}

// Boa prática (StringBuilder)
StringBuilder builder = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    builder.append("Data");  // Modifica o mesmo objeto
}
String result = builder.toString();
```

## Métodos Úteis

### Funcionalidades Adicionais
```java
StringBuilder cmd = new StringBuilder("EXECUTE");

// Capacidade
int cap = cmd.capacity();     // Capacidade atual
cmd.ensureCapacity(100);      // Garante capacidade mínima

// Modificação
cmd.setCharAt(0, 'e');       // Modifica caractere
cmd.setLength(4);            // Trunca ou expande
cmd.replace(0, 2, "RE");     // Substitui range
```

## Próximos Passos

### Tópicos Relacionados
- [Formatação de Strings](string-formatting.md)
- [StringBuffer](string-buffer.md)
- [Performance](performance.md)

[Formatação de Strings](string-formatting.md){.next-step}
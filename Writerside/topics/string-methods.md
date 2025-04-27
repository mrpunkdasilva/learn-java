# Métodos de String

## Métodos de Busca

### Localização
```java
String texto = "CYBERPUNK_2077";

// Busca
int posicao = texto.indexOf("PUNK");    // 5
int ultimo = texto.lastIndexOf("7");     // 12
boolean contem = texto.contains("CYBER"); // true
```

## Métodos de Transformação

### Modificação
```java
String codigo = "NetRunner";

// Transformações
String maiusculo = codigo.toUpperCase(); // "NETRUNNER"
String minusculo = codigo.toLowerCase(); // "netrunner"
String semEspacos = codigo.trim();      // Remove espaços
String[] partes = codigo.split("R");    // ["Net", "unner"]
```

## Métodos de Comparação

### Verificação
```java
String s1 = "MATRIX";
String s2 = "matrix";

// Comparações
boolean igual = s1.equals(s2);           // false
boolean ignoraCase = s1.equalsIgnoreCase(s2); // true
int comparacao = s1.compareTo(s2);       // Comparação lexicográfica
```

## Métodos de Substituição

### Alteração
```java
String log = "Error:404:NotFound";

// Substituições
String novo = log.replace(":", "-");     // "Error-404-NotFound"
String primeiro = log.replaceFirst(":", "-"); // "Error-404:NotFound"
```

## Próximos Passos

### Tópicos Relacionados
- [StringBuilder](string-builder.md)
- [Formatação de Strings](string-formatting.md)
- [Expressões Regulares](regex.md)

[StringBuilder](string-builder.md){.next-step}
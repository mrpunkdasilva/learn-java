# Strings em Java

## Visão Geral

```ascii
STRING CONCEPTS
├── Imutabilidade
├── Pool de Strings
├── Concatenação
└── Comparação
```

## Criação de Strings

### Formas de Inicialização
```java
// Literal
String comando = "EXECUTE";

// Construtor
String status = new String("ONLINE");

// Pool vs Heap
String s1 = "MATRIX";         // Pool de Strings
String s2 = new String("MATRIX"); // Heap
```

## Operações Básicas

### Manipulação
```java
String codigo = "NET_RUNNER";
int tamanho = codigo.length();     // 10
char primeiro = codigo.charAt(0);   // 'N'
String sub = codigo.substring(0,3); // "NET"
```

## Próximos Passos

### Tópicos Detalhados
- [Métodos de String](string-methods.md)
- [StringBuilder](string-builder.md)
- [Formatação de Strings](string-formatting.md)

[Métodos de String](string-methods.md){.next-step}

---

> "Strings são como os dados criptografados da Matrix - precisam ser manipulados com precisão e eficiência."
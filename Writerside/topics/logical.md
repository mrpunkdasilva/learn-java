# Operadores Lógicos

## Operadores Básicos

### Booleanos
```java
// AND lógico (&&)
boolean and = true && false;  // false

// OR lógico (||)
boolean or = true || false;   // true

// NOT lógico (!)
boolean not = !true;         // false
```

## Curto-Circuito

### Avaliação Otimizada
```java
// AND com curto-circuito
if (obj != null && obj.getValue() > 0) {
    // Segundo termo só é avaliado se obj != null
}

// OR com curto-circuito
if (cache.containsKey(key) || loadFromDatabase()) {
    // loadFromDatabase() só é chamado se necessário
}
```

## Operadores Bit a Bit Booleanos

### Operações sem Curto-Circuito
```java
// AND bit a bit (&)
boolean bitwiseAnd = true & false;

// OR bit a bit (|)
boolean bitwiseOr = true | false;

// XOR bit a bit (^)
boolean xor = true ^ false;
```

## Próximos Passos

### Tópicos Relacionados
- [Operadores Bit a Bit](bitwise.md)
- [Estruturas Condicionais](conditionals.md)
- [Expressões Booleanas](boolean-expressions.md)

[Operadores Bit a Bit](bitwise.md){.next-step}
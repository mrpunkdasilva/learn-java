# Operadores Bit a Bit

## Operadores Básicos

### Manipulação de Bits
```java
// AND bit a bit (&)
int and = 12 & 5;   // 1100 & 0101 = 0100 (4)

// OR bit a bit (|)
int or = 12 | 5;    // 1100 | 0101 = 1101 (13)

// XOR bit a bit (^)
int xor = 12 ^ 5;   // 1100 ^ 0101 = 1001 (9)

// NOT bit a bit (~)
int not = ~12;      // ~1100 = ...11110011
```

## Operadores de Deslocamento

### Shift de Bits
```java
// Shift left (<<)
int left = 8 << 2;    // 1000 -> 100000 (32)

// Shift right (>>)
int right = 8 >> 2;   // 1000 -> 0010 (2)

// Shift right sem sinal (>>>)
int unsignedRight = -8 >>> 2;  // Preenche com 0
```

## Aplicações Práticas

### Uso Comum
```java
// Flags de bit
int FLAG_READ = 1;     // 0001
int FLAG_WRITE = 2;    // 0010
int FLAG_EXECUTE = 4;  // 0100

// Combinando flags
int permissions = FLAG_READ | FLAG_WRITE;  // 0011

// Verificando flags
boolean canRead = (permissions & FLAG_READ) != 0;
```

### Otimizações
```java
// Multiplicação por 2
int multiply = num << 1;  // Equivalente a num * 2

// Divisão por 2
int divide = num >> 1;    // Equivalente a num / 2

// Alternância de bit
int toggleBit = num ^ (1 << position);
```

## Máscaras de Bits

### Técnicas de Mascaramento
```java
// Máscara para últimos 8 bits
int mask = 0xFF;

// Aplicando máscara
int lastByte = number & mask;

// Limpando bits
int clearBits = number & ~mask;
```

## Próximos Passos

### Tópicos Relacionados
- [Tipos Primitivos](primitive-types.md)
- [Operadores Lógicos](logical.md)

[Tipos Primitivos](primitive-types.md){.next-step}

---

> "Os operadores bit a bit são como os comandos de baixo nível da Matrix - manipulando a realidade digital bit por bit."
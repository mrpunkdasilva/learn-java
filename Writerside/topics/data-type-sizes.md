# Tamanhos dos Tipos de Dados

## Visão Geral

```ascii
MEMORY ALLOCATION
├── Inteiros
│   ├── byte  (8 bits  = 1 byte)
│   ├── short (16 bits = 2 bytes)
│   ├── int   (32 bits = 4 bytes)
│   └── long  (64 bits = 8 bytes)
├── Decimais
│   ├── float  (32 bits = 4 bytes)
│   └── double (64 bits = 8 bytes)
├── Caractere
│   └── char   (16 bits = 2 bytes)
└── Lógico
    └── boolean (1 bit, JVM usa 1 byte)
```

## Capacidade de Armazenamento

### Inteiros
```java
// byte (8 bits)
// Range: -2^7 até 2^7-1
// Range: -128 até 127
byte minByte = -128;
byte maxByte = 127;

// short (16 bits)
// Range: -2^15 até 2^15-1
// Range: -32,768 até 32,767
short minShort = -32768;
short maxShort = 32767;

// int (32 bits)
// Range: -2^31 até 2^31-1
// Range: -2,147,483,648 até 2,147,483,647
int minInt = -2147483648;
int maxInt = 2147483647;

// long (64 bits)
// Range: -2^63 até 2^63-1
// Range: -9,223,372,036,854,775,808 até 9,223,372,036,854,775,807
long minLong = -9223372036854775808L;
long maxLong = 9223372036854775807L;
```

## Representação na Memória

### Visualização dos Bits
```ascii
BYTE REPRESENTATION (8 bits)
├── Positivo: 0000 0001 = 1
├── Negativo: 1111 1111 = -1
└── Zero:     0000 0000 = 0
```

### Ponto Flutuante
```ascii
FLOAT/DOUBLE FORMAT
├── Sign bit (1 bit)
├── Exponent (8/11 bits)
└── Mantissa (23/52 bits)
```

## Impacto na Performance

### Uso de Memória
```ascii
MEMORY USAGE
├── Arrays de 1000 elementos
│   ├── byte[]  = 1000 bytes
│   ├── short[] = 2000 bytes
│   ├── int[]   = 4000 bytes
│   └── long[]  = 8000 bytes
```

### Escolha do Tipo
```ascii
SELECTION CRITERIA
├── Pequenos números → byte/short
├── Uso geral → int
├── Números grandes → long
├── Precisão decimal → double
└── Economia de memória → tipos menores
```

## Considerações Práticas

### Quando Usar Cada Tamanho
```ascii
USE CASES
├── byte
│   ├── Valores de status (-128 a 127)
│   └── Arrays grandes com valores pequenos
├── short
│   ├── Ano (ex: 2024)
│   └── Códigos de erro
├── int
│   ├── Contadores
│   └── Índices
└── long
    ├── IDs únicos
    └── Timestamps
```

## Próximos Passos

### Tópicos Relacionados
- [Tipos Primitivos](primitive-types.md)
- [Type Casting](type-casting.md)
- [Operadores](operators.md)

[Tipos Primitivos](primitive-types.md){.next-step}

---

> "Cada bit é como um pulso na Matrix - precisamos entender seu tamanho e capacidade para otimizar nosso código."
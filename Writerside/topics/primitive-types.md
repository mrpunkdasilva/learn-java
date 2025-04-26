# Tipos Primitivos

```ascii
PRIMITIVE DATA TYPES
├── Inteiros
│   ├── byte  (8 bits)
│   ├── short (16 bits)
│   ├── int   (32 bits)
│   └── long  (64 bits)
├── Decimais
│   ├── float  (32 bits)
│   └── double (64 bits)
├── Caractere
│   └── char   (16 bits)
└── Lógico
    └── boolean (1 bit)
```

## Tipos Numéricos Inteiros

### byte
```java
// Range: -128 até 127
byte nivelPoder = 100;
byte codigoStatus = -50;
```

### short
```java
// Range: -32,768 até 32,767
short populacao = 30000;
short temperatura = -200;
```

### int
```java
// Range: -2^31 até 2^31-1
int usuarios = 1000000;
int pontuacao = 2147483647;
```

### long
```java
// Range: -2^63 até 2^63-1
long populacaoMundial = 7800000000L;
long distanciaEspacial = 9223372036854775807L;
```

## Tipos Numéricos Decimais

### float
```java
// Precisão: 6-7 dígitos decimais
float taxa = 19.99f;
float temperatura = -273.15f;
```

### double
```java
// Precisão: 15-16 dígitos decimais
double pi = 3.141592653589793;
double velocidadeLuz = 299792458.0;
```

## Tipo Caractere

### char
```java
// Unicode 16-bit
char nivel = 'A';
char simbolo = '$';
char unicode = '\u0041'; // 'A'
```

## Tipo Booleano

### boolean
```java
// Valores: true ou false
boolean sistemaAtivo = true;
boolean acessoPermitido = false;
```

## Valores Padrão

### Inicialização Automática
```ascii
DEFAULT VALUES
├── byte, short, int, long → 0
├── float, double → 0.0
├── char → '\u0000'
└── boolean → false
```

## Limites e Constantes

### Valores Máximos e Mínimos
```java
// Constantes úteis
byte maxByte = Byte.MAX_VALUE;    // 127
int minInt = Integer.MIN_VALUE;   // -2147483648
long maxLong = Long.MAX_VALUE;    // 9223372036854775807
```

## Literais Numéricos

### Representações
```java
// Decimal
int decimal = 1234;

// Hexadecimal
int hexadecimal = 0xFF; // 255

// Binário
int binario = 0b1010; // 10

// Octal
int octal = 0757; // 495
```

## Separador de Dígitos

### Uso do Underscore
```java
// Melhorando legibilidade
long cartaoCredito = 1234_5678_9012_3456L;
int milhao = 1_000_000;
```

## Considerações de Performance

### Escolha do Tipo
```ascii
PERFORMANCE TIPS
├── Use int para loops
├── Prefira double a float
├── byte/short para arrays grandes
└── boolean para flags
```

## Próximos Passos

### Tópicos Relacionados
- [Tipos de Referência](reference-types.md)
- [Type Casting](type-casting.md)
- [Operadores](operators.md)

[Tipos de Referência](reference-types.md){.next-step}

---

> "Os tipos primitivos são como os átomos da Matrix - as unidades fundamentais que compõem toda a realidade digital."
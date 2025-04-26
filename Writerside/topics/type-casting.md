# Type Casting em Java

```ascii
TYPE CASTING
├── Implícito (Widening)
├── Explícito (Narrowing)
├── Referência
└── Autoboxing/Unboxing
```

## Casting Implícito

### Widening Casting
```ascii
WIDENING PATH
byte → short → int → long → float → double
        char ↗
```

### Exemplos
```java
// Conversões automáticas
byte byteNum = 100;
int intNum = byteNum; // byte para int

int intValue = 10;
double doubleValue = intNum; // int para double
```

## Casting Explícito

### Narrowing Casting
```ascii
NARROWING PATH
double → float → long → int → short → byte
                        ↘ char
```

### Exemplos
```java
// Conversões manuais
double doubleNum = 9.78;
int intNum = (int) doubleNum; // double para int

int largeNum = 130;
byte byteNum = (byte) largeNum; // int para byte
```

## Casting de Referência

### Upcasting
```java
// Classe pai para filho
class Animal {}
class Gato extends Animal {}

Animal animal = new Gato(); // Upcast automático
```

### Downcasting
```java
// Filho para pai (requer verificação)
Animal animal = new Gato();
if (animal instanceof Gato) {
    Gato gato = (Gato) animal; // Downcast explícito
}
```

## Autoboxing e Unboxing

### Autoboxing
```java
// Primitivo para Wrapper
int primitivo = 42;
Integer wrapper = primitivo; // Autoboxing
```

### Unboxing
```java
// Wrapper para primitivo
Integer wrapper = 42;
int primitivo = wrapper; // Unboxing
```

## Verificações de Tipo

### instanceof
```java
Object obj = "teste";
if (obj instanceof String) {
    String str = (String) obj;
    System.out.println(str.length());
}
```

### Pattern Matching (Java 16+)
```java
Object obj = "teste";
if (obj instanceof String str) {
    System.out.println(str.length());
}
```

## Conversões Comuns

### String Conversions
```java
// String para número
String strNum = "42";
int num = Integer.parseInt(strNum);
double dNum = Double.parseDouble("3.14");

// Número para String
String str1 = String.valueOf(42);
String str2 = Integer.toString(42);
```

## Perda de Dados

### Exemplos
```java
// Perda de precisão
int x = 128;
byte b = (byte) x; // Overflow: -128

double pi = 3.14159;
int iPi = (int) pi; // Truncado: 3
```

## Boas Práticas

### Recomendações
```ascii
CASTING GUIDELINES
├── Prefira casting implícito
├── Verifique antes de downcast
├── Evite casting numérico arriscado
└── Use métodos de conversão apropriados
```

### Exemplo Seguro
```java
// Verificação de range
long longValue = 42L;
if (longValue >= Integer.MIN_VALUE && 
    longValue <= Integer.MAX_VALUE) {
    int intValue = (int) longValue;
}
```

## Casos Especiais

### Char Casting
```java
// Char para número
char ch = 'A';
int ascii = ch; // 65

// Número para char
int num = 66;
char character = (char) num; // 'B'
```

## Próximos Passos

### Tópicos Relacionados
- [Palavra-chave var](var-keyword.md)
- [Operadores](operators.md)
- [Tipos de Dados](variables.md)

[Palavra-chave var](var-keyword.md){.next-step}

---

> "O type casting é como hackear a Matrix - transformando dados de uma forma para outra."
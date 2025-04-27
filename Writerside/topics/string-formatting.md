# Formatação de Strings

## String.format()

### Sintaxe Básica
```java
// Formatação básica
String msg = String.format("Usuário: %s, ID: %d", "Neo", 1337);

// Números
String num = String.format("%.2f", 3.14159);  // "3.14"
String hex = String.format("%x", 255);        // "ff"
```

## System.out.printf()

### Saída Formatada
```java
// Impressão formatada
System.out.printf("Status: %s%n", "ONLINE");

// Múltiplos argumentos
System.out.printf("X: %d, Y: %d%n", 10, 20);
```

## Especificadores de Formato

### Tipos Comuns
```java
// Strings e caracteres
%s  // String
%c  // Caractere
%n  // Nova linha

// Números
%d  // Inteiro decimal
%f  // Ponto flutuante
%e  // Notação científica
%x  // Hexadecimal
```

## Flags de Formatação

### Modificadores
```java
// Alinhamento e preenchimento
String align = String.format("|%-10s|", "LEFT");   // Alinha à esquerda
String pad = String.format("%05d", 42);            // "00042"

// Números
String prec = String.format("%.3f", 3.14159);      // "3.142"
String group = String.format("%,d", 1000000);      // "1,000,000"
```

## MessageFormat

### Formatação Complexa
```java
import java.text.MessageFormat;

// Padrão de mensagem
String pattern = "User {0} logged in at {1}";
String msg = MessageFormat.format(pattern, "Trinity", "12:00");

// Números e datas
MessageFormat mf = new MessageFormat("Balance: {0,number,currency}");
String balance = mf.format(new Object[]{1234.56});
```

## Próximos Passos

### Tópicos Relacionados
- [Internacionalização](i18n.md)
- [Formatação de Datas](date-formatting.md)
- [Formatação de Números](number-formatting.md)

[Internacionalização](i18n.md){.next-step}

---

> "A formatação de strings é como a interface da Matrix - a forma como apresentamos os dados ao mundo real."
# Switch Expressions

```ascii
>> Inicializando sistema de expressões switch...
>> Carregando padrões de correspondência...
>> Estabelecendo rotas de decisão...
```

## Introdução

O switch expression é uma feature moderna do Java que oferece uma forma mais concisa e segura de escrever estruturas de decisão múltipla.

## Sintaxe Básica

### Switch Expression Tradicional
```java
String status = switch (statusCode) {
    case 200 -> "OK";
    case 404 -> "Not Found";
    case 500 -> "Internal Server Error";
    default -> "Unknown Status";
};
```

### Switch com Múltiplos Casos
```java
String category = switch (score) {
    case 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100 -> "A";
    case 80, 81, 82, 83, 84, 85, 86, 87, 88, 89 -> "B";
    case 70, 71, 72, 73, 74, 75, 76, 77, 78, 79 -> "C";
    default -> "F";
};
```

## Recursos Avançados

### Yield
```java
String message = switch (level) {
    case "INFO" -> {
        logInfo();
        yield "Information message";
    }
    case "WARNING" -> {
        logWarning();
        yield "Warning message";
    }
    case "ERROR" -> {
        logError();
        yield "Error message";
    }
    default -> "Unknown level";
};
```

### Pattern Matching (Preview)
```java
String typeCheck = switch (obj) {
    case String s -> "Text: " + s;
    case Integer i -> "Number: " + i;
    case Long l -> "Long: " + l;
    case null -> "Null value";
    default -> "Unknown type";
};
```

## Boas Práticas

1. **Expressividade**
   - Use nomes descritivos para variáveis
   - Mantenha casos relacionados agrupados
   - Evite lógica complexa dentro dos casos

2. **Organização**
   - Ordene os casos de forma lógica
   - Agrupe casos similares
   - Use comentários para documentar casos complexos

3. **Manutenibilidade**
   - Evite fallthrough entre casos
   - Sempre inclua um caso default
   - Mantenha a lógica simples e direta

## Exemplos Práticos

### Processador de Status HTTP
```java
HttpResponse processStatus(int code) {
    return switch (code) {
        case 200, 201, 202 -> new SuccessResponse();
        case 400, 401, 403 -> new ClientErrorResponse();
        case 500, 502, 503 -> new ServerErrorResponse();
        default -> new UnknownResponse();
    };
}
```

### Calculadora Simples
```java
double calculate(double a, double b, String operator) {
    return switch (operator) {
        case "+" -> a + b;
        case "-" -> a - b;
        case "*" -> a * b;
        case "/" -> {
            if (b == 0) {
                throw new ArithmeticException("Divisão por zero");
            }
            yield a / b;
        }
        default -> throw new IllegalArgumentException("Operador inválido");
    };
}
```

## Troubleshooting

### Problemas Comuns

1. **Esquecimento do Default**
```java
// Incorreto - Compilação falha
String result = switch (value) {
    case 1 -> "Um";
    case 2 -> "Dois";
}; // Erro: falta caso default

// Correto
String result = switch (value) {
    case 1 -> "Um";
    case 2 -> "Dois";
    default -> "Outro";
};
```

2. **Mistura de Arrow e Block**
```java
// Incorreto - Sintaxe inconsistente
String result = switch (value) {
    case 1 -> "Um"
    case 2: yield "Dois";
};

// Correto
String result = switch (value) {
    case 1 -> "Um";
    case 2 -> "Dois";
};
```

## Exercícios Práticos

1. **Conversor de Dia da Semana**
```java
String getDayName(int day) {
    return switch (day) {
        case 1 -> "Domingo";
        case 2 -> "Segunda";
        case 3 -> "Terça";
        case 4 -> "Quarta";
        case 5 -> "Quinta";
        case 6 -> "Sexta";
        case 7 -> "Sábado";
        default -> "Dia inválido";
    };
}
```

2. **Classificador de Notas**
```java
String classifyGrade(double grade) {
    return switch ((int) grade / 10) {
        case 10, 9 -> "A";
        case 8 -> "B";
        case 7 -> "C";
        case 6 -> "D";
        default -> "F";
    };
}
```

## Próximos Passos

- Explore pattern matching em [Pattern Matching](pattern-matching.md)
- Pratique com exercícios em [Control Flow Projects](control-flow-projects.md)
- Aprenda sobre expressões lambda em [Lambda](lambda.md)

[Pattern Matching](pattern-matching.md){.next-step}
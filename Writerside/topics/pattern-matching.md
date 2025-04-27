# Pattern Matching

```ascii
>> Inicializando sistema de correspondência de padrões...
>> Carregando tipos de dados...
>> Estabelecendo regras de matching...
```

## Introdução

Pattern Matching é uma feature moderna do Java que permite testar e extravar valores de objetos de forma mais elegante e segura.

## Pattern Matching com instanceof

### Sintaxe Tradicional vs. Nova
```java
// Forma antiga
if (obj instanceof String) {
    String str = (String) obj;
    System.out.println(str.length());
}

// Pattern Matching
if (obj instanceof String str) {
    System.out.println(str.length());
}
```

### Uso com Negação
```java
if (!(obj instanceof String str)) {
    return;
}
// str está disponível aqui
System.out.println(str.length());
```

## Pattern Matching em Switch (Preview)

### Matching por Tipo
```java
String formatted = switch (obj) {
    case String str -> "String: " + str.toUpperCase();
    case Integer num -> "Int: " + num.toString();
    case Double d -> "Double: " + String.format("%.2f", d);
    case null -> "null";
    default -> "Unknown: " + obj.toString();
};
```

### Guarded Patterns
```java
String checkNumber = switch (num) {
    case Integer i when i < 0 -> "Negativo";
    case Integer i when i > 0 -> "Positivo";
    case Integer i -> "Zero";
    default -> "Não é um número";
};
```

## Casos de Uso Avançados

### Hierarquia de Classes
```java
public sealed interface Shape 
    permits Circle, Rectangle, Triangle {}

record Circle(double radius) implements Shape {}
record Rectangle(double width, double height) implements Shape {}
record Triangle(double base, double height) implements Shape {}

double calculateArea(Shape shape) {
    return switch (shape) {
        case Circle c -> Math.PI * c.radius() * c.radius();
        case Rectangle r -> r.width() * r.height();
        case Triangle t -> (t.base() * t.height()) / 2;
    };
}
```

### Processamento de Dados
```java
String processData(Object data) {
    return switch (data) {
        case String s when s.length() > 10 -> "String longa: " + s.substring(0, 10) + "...";
        case String s -> "String: " + s;
        case List<?> list when list.isEmpty() -> "Lista vazia";
        case List<?> list -> "Lista com " + list.size() + " elementos";
        case Map<?, ?> map -> "Map com " + map.size() + " entradas";
        case null -> "Dado nulo";
        default -> "Tipo não suportado";
    };
}
```

## Boas Práticas

1. **Clareza**
   - Use nomes descritivos para variáveis de pattern
   - Mantenha padrões simples e diretos
   - Documente casos complexos

2. **Organização**
   - Ordene casos do mais específico para o mais genérico
   - Agrupe padrões relacionados
   - Use guards para refinar a lógica

3. **Performance**
   - Evite operações pesadas em guards
   - Considere a ordem dos padrões
   - Mantenha o código eficiente

## Exemplos Práticos

### Validador de Dados
```java
String validateInput(Object input) {
    return switch (input) {
        case String s when s.isBlank() -> "String vazia";
        case String s when s.matches("\\d+") -> "Número válido: " + s;
        case String s -> "Texto válido: " + s;
        case Integer i when i >= 0 -> "Número positivo: " + i;
        case Integer i -> "Número negativo: " + i;
        case null -> "Input nulo";
        default -> "Input inválido";
    };
}
```

### Processador de Eventos
```java
void processEvent(Event event) {
    switch (event) {
        case UserEvent u when u.isAdmin() -> handleAdminEvent(u);
        case UserEvent u -> handleUserEvent(u);
        case SystemEvent s when s.isCritical() -> handleCriticalSystemEvent(s);
        case SystemEvent s -> handleSystemEvent(s);
        case null -> throw new IllegalArgumentException("Evento nulo");
        default -> handleUnknownEvent(event);
    }
}
```

## Troubleshooting

### Problemas Comuns

1. **Ordem dos Patterns**
```java
// Incorreto - Padrão inalcançável
switch (obj) {
    case Object o -> "Objeto";    // Captura tudo
    case String s -> "String";    // Nunca alcançado
}

// Correto
switch (obj) {
    case String s -> "String";    // Mais específico primeiro
    case Object o -> "Objeto";    // Mais genérico depois
}
```

2. **Null Handling**
```java
// Incorreto - NullPointerException possível
switch (obj) {
    case String s -> s.length();
    default -> 0;
}

// Correto
switch (obj) {
    case null -> 0;
    case String s -> s.length();
    default -> 0;
}
```

## Exercícios Práticos

1. **Analisador de Dados**
```java
String analyzeData(Object data) {
    return switch (data) {
        case String s when s.contains("@") -> "Email: " + s;
        case String s when s.matches("\\d{10}") -> "Telefone: " + s;
        case String s -> "Texto: " + s;
        case Integer i -> "Número: " + i;
        case List<?> l -> "Lista[" + l.size() + "]";
        case null -> "NULO";
        default -> "Desconhecido";
    };
}
```

2. **Calculadora de Formas**
```java
record Point(int x, int y) {}
record Circle(Point center, double radius) {}
record Rectangle(Point topLeft, double width, double height) {}

String describeShape(Object shape) {
    return switch (shape) {
        case Circle c -> 
            String.format("Círculo em (%d,%d) com raio %.2f",
                c.center().x(), c.center().y(), c.radius());
        case Rectangle r -> 
            String.format("Retângulo em (%d,%d) de %.2fx%.2f",
                r.topLeft().x(), r.topLeft().y(), r.width(), r.height());
        case null -> "Forma nula";
        default -> "Forma não reconhecida";
    };
}
```

## Próximos Passos

- Explore expressões switch em [Switch Expressions](switch-expressions.md)
- Pratique com projetos em [Control Flow Projects](control-flow-projects.md)
- Aprenda sobre sealed classes em [Sealed Classes](sealed-classes.md)

[Control Flow Projects](control-flow-projects.md){.next-step}
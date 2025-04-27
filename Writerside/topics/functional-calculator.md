# Calculadora Funcional

## Visão Geral
A Calculadora Funcional é um projeto avançado que demonstra os princípios da programação funcional em Java, utilizando expressões lambda, funções de ordem superior e composição de funções.

## Objetivos
- Implementar operações matemáticas usando programação funcional
- Demonstrar o uso de expressões lambda e referências de método
- Criar um sistema de composição de operações
- Implementar histórico de operações usando streams

## Implementação

### Estrutura Base

```java
@FunctionalInterface
public interface Operation<T> {
    T apply(T a, T b);
}

public class FunctionalCalculator {
    private final List<String> history = new ArrayList<>();
    
    @Operation("ADD")
    public Function<Double, Double> add(Double a) {
        return b -> {
            double result = a + b;
            logOperation("ADD", a, b, result);
            return result;
        };
    }
    
    @Operation("MULTIPLY")
    public Function<Double, Double> multiply(Double a) {
        return b -> {
            double result = a * b;
            logOperation("MULTIPLY", a, b, result);
            return result;
        };
    }
    
    private void logOperation(String op, Double a, Double b, Double result) {
        history.add(String.format("%s: %f %s %f = %f", 
            op, a, op.toLowerCase(), b, result));
    }
    
    public List<String> getHistory() {
        return Collections.unmodifiableList(history);
    }
}
```

### Composição de Operações

```java
public class OperationComposer {
    @Operation("COMPOSE")
    public <T> Function<T, T> compose(
        @OperationParam Function<T, T>... functions
    ) {
        return Arrays.stream(functions)
                    .reduce(Function.identity(), Function::andThen);
    }
}
```

## Exemplos de Uso

### Operações Básicas
```java
FunctionalCalculator calc = new FunctionalCalculator();

// Operação simples
double result = calc.add(5.0).apply(3.0);  // 8.0

// Composição de operações
Function<Double, Double> operation = calc.compose(
    calc.add(5.0),
    calc.multiply(2.0)
);
double composedResult = operation.apply(3.0);  // 16.0
```

### Histórico de Operações
```java
calc.getHistory().forEach(System.out::println);
// Saída:
// ADD: 5.000000 add 3.000000 = 8.000000
// MULTIPLY: 8.000000 multiply 2.000000 = 16.000000
```

## Exercícios Propostos

1. Implementar operações adicionais:
   - Subtração
   - Divisão
   - Potenciação
   - Raiz quadrada

2. Adicionar validações:
   - Divisão por zero
   - Números negativos em raiz quadrada
   - Overflow/Underflow

3. Implementar operações com diferentes tipos:
   - Inteiros
   - Números complexos
   - Vetores

## Desafios Avançados

### 1. Sistema de Plugins
Criar um sistema que permite adicionar novas operações dinamicamente:

```java
public interface OperationPlugin {
    String getName();
    Function<Double, Double> getOperation(Double input);
}
```

### 2. Expressões Matemáticas
Implementar um parser de expressões matemáticas:

```java
public class ExpressionParser {
    public Function<Double, Double> parse(String expression) {
        // Implementação do parser
    }
}
```

### 3. Operações Assíncronas
Adicionar suporte para cálculos assíncronos:

```java
public class AsyncCalculator {
    public CompletableFuture<Double> calculateAsync(
        Function<Double, Double> operation,
        Double input
    ) {
        return CompletableFuture.supplyAsync(
            () -> operation.apply(input)
        );
    }
}
```

## Boas Práticas

1. Imutabilidade
   - Use tipos imutáveis
   - Evite estado mutável
   - Retorne novas instâncias

2. Composição
   - Prefira composição sobre herança
   - Use funções pequenas e focadas
   - Combine funções para operações complexas

3. Tratamento de Erros
   - Use Optional para resultados opcionais
   - Implemente tratamento de exceções funcional
   - Mantenha a transparência referencial

## Recursos Adicionais

- [Documentação Java Stream API](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)
- [Tutorial sobre Programação Funcional](functional-programming.md)
- [Padrões Funcionais](functional-patterns.md)

## Próximos Passos

Após completar este projeto, você estará preparado para:
- Desenvolver sistemas mais complexos usando programação funcional
- Implementar operações assíncronas e paralelas
- Criar DSLs (Domain Specific Languages) funcionais
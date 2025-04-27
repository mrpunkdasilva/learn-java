# Calculadora Básica

## Conceitos Aplicados
- Variáveis primitivas (`int`, `double`)
- Operadores aritméticos
- Type casting
- Palavra-chave `var`

## Implementação Base

```java
public class Calculator {
    // Usando tipos primitivos para armazenar resultados
    private double result;
    
    // Demonstração de operadores aritméticos básicos
    public double add(double a, double b) {
        result = a + b;
        return result;
    }
    
    public double subtract(double a, double b) {
        result = a - b;
        return result;
    }
    
    // Exemplo de casting implícito
    public double multiply(int a, double b) {
        result = a * b; // int é automaticamente convertido para double
        return result;
    }
    
    // Demonstração de var com inferência de tipo
    public double divide(double a, double b) {
        var quotient = a / b; // var infere double
        result = quotient;
        return result;
    }
}
```

## Exercícios Propostos

1. Implementar operações com diferentes tipos numéricos
2. Praticar conversões explícitas entre tipos
3. Explorar precedência de operadores
4. Usar var em diferentes contextos

## Desafios
1. Adicionar operações com números inteiros e decimais
2. Implementar conversões entre tipos numéricos
3. Criar operações com diferentes precedências

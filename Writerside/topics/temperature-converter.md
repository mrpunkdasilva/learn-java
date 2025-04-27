# Conversor de Temperatura

## Conceitos Aplicados
- Tipos primitivos (`double`)
- Operadores aritméticos
- Type casting
- Operadores lógicos

## Implementação Base

```java
public class TemperatureConverter {
    // Demonstração de constantes com tipos primitivos
    private static final double ABSOLUTE_ZERO_C = -273.15;
    
    // Uso de operadores aritméticos e type casting
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
    
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
    
    // Demonstração de operadores lógicos
    public boolean isValidTemperature(double celsius) {
        return celsius >= ABSOLUTE_ZERO_C;
    }
}
```

## Exercícios Propostos

1. Trabalhar com diferentes escalas de precisão
2. Implementar validações usando operadores lógicos
3. Praticar conversões entre tipos numéricos
4. Explorar formatação de números decimais

## Desafios
1. Adicionar validações de temperatura
2. Implementar arredondamento de resultados
3. Criar verificações de limites físicos

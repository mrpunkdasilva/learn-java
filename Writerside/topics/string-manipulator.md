# Manipulador de Strings

## Conceitos Aplicados
- String como tipo de referência
- Métodos de String
- StringBuilder
- String formatting

## Implementação Base

```java
public class StringManipulator {
    // Demonstração de String como tipo de referência
    private String text;
    
    public StringManipulator(String text) {
        this.text = text;
    }
    
    // Uso de métodos de String
    public String toUpperCase() {
        return text.toUpperCase();
    }
    
    // Demonstração de StringBuilder
    public String reverse() {
        StringBuilder builder = new StringBuilder(text);
        return builder.reverse().toString();
    }
    
    // Exemplo de String formatting
    public String format() {
        return String.format("Texto: %s, Tamanho: %d", 
                           text, text.length());
    }
}
```

## Exercícios Propostos

1. Explorar métodos da classe String
2. Praticar concatenação com StringBuilder
3. Implementar diferentes formatos de string
4. Trabalhar com substrings e caracteres

## Desafios
1. Criar diferentes formatos de saída
2. Implementar manipulações de texto
3. Otimizar operações com StringBuilder

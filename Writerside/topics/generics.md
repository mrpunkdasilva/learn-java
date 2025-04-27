# Generics: Flexibilidade com Tipo Seguro

```ascii
GENERICS MAP
├── Type Parameters
├── Generic Classes
├── Generic Methods
└── Type Bounds
```

## Conceitos Básicos

### Type Parameters
```java
// T é um type parameter comum
public class Box<T> {
    private T content;
    
    public void store(T item) {
        this.content = item;
    }
    
    public T retrieve() {
        return content;
    }
}
```

### Convenções de Nomenclatura
- `T` - Tipo genérico
- `E` - Elemento
- `K` - Chave
- `V` - Valor
- `N` - Número

## Wildcards

### Upper Bounded
```java
// Aceita Number ou subtipos
public void process(List<? extends Number> numbers) {
    for (Number n : numbers) {
        System.out.println(n.doubleValue());
    }
}
```

### Lower Bounded
```java
// Aceita Integer ou supertipos
public void addNumbers(List<? super Integer> list) {
    list.add(10);
    list.add(20);
}
```

## Type Erasure

O Java usa type erasure para implementar generics:
```java
// Em tempo de compilação
List<String> strings = new ArrayList<String>();

// Em runtime se torna
List strings = new ArrayList();
```

## Práticas Recomendadas

1. **Use Generics para Collections**
```java
// Ruim
List lista = new ArrayList();

// Bom
List<String> lista = new ArrayList<>();
```

2. **Defina Bounds Quando Necessário**
```java
public class NumericBox<T extends Number> {
    private T number;
    
    public double getValue() {
        return number.doubleValue();
    }
}
```

## Exercício Prático

Implemente uma classe genérica `Stack<T>`:
```java
public class Stack<T> {
    private List<T> items = new ArrayList<>();
    
    public void push(T item) {
        items.add(item);
    }
    
    public T pop() {
        if (items.isEmpty()) {
            throw new EmptyStackException();
        }
        return items.remove(items.size() - 1);
    }
}
```
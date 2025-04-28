# Padrões Criacionais

```ascii
DESIGN PATTERNS
├── Creational
│   ├── Singleton
│   ├── Factory Method
│   ├── Abstract Factory
│   ├── Builder
│   └── Prototype
```

## Visão Geral

Os padrões criacionais são fundamentais no desenvolvimento Java, fornecendo soluções elegantes para a criação de objetos. Eles abstraem o processo de instanciação, tornando o sistema independente de como seus objetos são criados, compostos e representados.

## Principais Padrões

### 1. Singleton

Garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso a ela.

```java
public class DatabaseConnection {
    private static DatabaseConnection instance;
    
    private DatabaseConnection() {}
    
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
```

### 2. Factory Method

Define uma interface para criar objetos, mas permite que as subclasses decidam qual classe instanciar.

```java
public interface Animal {
    void makeSound();
}

public class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof!");
    }
}

public class AnimalFactory {
    public Animal createAnimal(String type) {
        return switch (type.toLowerCase()) {
            case "dog" -> new Dog();
            case "cat" -> new Cat();
            default -> throw new IllegalArgumentException("Animal type not supported");
        };
    }
}
```

### 3. Abstract Factory

Fornece uma interface para criar famílias de objetos relacionados sem especificar suas classes concretas.

```java
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

public class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
```

### 4. Builder

Separa a construção de um objeto complexo da sua representação, permitindo criar diferentes representações.

```java
public class Computer {
    private final String cpu;
    private final String ram;
    private final String storage;
    
    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        
        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }
        
        public Builder ram(String ram) {
            this.ram = ram;
            return this;
        }
        
        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }
        
        public Computer build() {
            return new Computer(this);
        }
    }
    
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }
}
```

### 5. Prototype

Especifica os tipos de objetos a serem criados usando uma instância prototípica e cria novos objetos copiando este protótipo.

```java
public interface Prototype extends Cloneable {
    Prototype clone();
}

public class Document implements Prototype {
    private String content;
    
    public Document(String content) {
        this.content = content;
    }
    
    @Override
    public Document clone() {
        return new Document(this.content);
    }
}
```

## Quando Usar

| Padrão | Uso Recomendado |
|--------|-----------------|
| Singleton | Quando precisar de uma única instância compartilhada em todo o sistema |
| Factory Method | Quando a criação de objetos deve ser flexível e extensível |
| Abstract Factory | Quando precisar criar famílias de objetos relacionados |
| Builder | Quando a construção de objetos envolver muitos parâmetros e configurações |
| Prototype | Quando a criação de objetos for custosa e puder ser otimizada por clonagem |

## Melhores Práticas

1. **Escolha Adequada**
   - Analise cuidadosamente os requisitos antes de escolher um padrão
   - Considere o impacto na manutenibilidade e testabilidade

2. **Implementação**
   - Mantenha o código limpo e bem documentado
   - Use nomes descritivos para classes e métodos
   - Siga os princípios SOLID

3. **Performance**
   - Considere o impacto no desempenho
   - Otimize quando necessário
   - Use lazy loading quando apropriado

## Anti-Patterns

- Uso excessivo de Singleton
- Factories muito complexas
- Builders com poucos parâmetros
- Prototypes sem necessidade real de clonagem

## Exercícios Práticos

1. Implemente um pool de conexões usando Singleton
2. Crie uma fábrica de documentos com Factory Method
3. Desenvolva um sistema de UI com Abstract Factory
4. Construa um builder para objetos de configuração
5. Implemente um sistema de clonagem de templates

## Recursos Adicionais

- [Design Patterns - GoF](https://refactoring.guru/design-patterns/creational-patterns)
- [Java Design Patterns](https://java-design-patterns.com/patterns/)
- [Effective Java - Joshua Bloch](https://www.oreilly.com/library/view/effective-java-3rd/9780134686097/)

## Próximos Passos

- Explore padrões estruturais
- Estude padrões comportamentais
- Pratique com projetos reais
- Analise implementações em frameworks populares

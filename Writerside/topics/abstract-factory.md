# Abstract Factory Pattern

## Visão Geral

O Abstract Factory é um padrão criacional que fornece uma interface para criar famílias de objetos relacionados sem especificar suas classes concretas.

```ascii
ABSTRACT FACTORY
├── Abstract Factory (Interface)
├── Concrete Factories
├── Abstract Products
└── Concrete Products
```

## Implementações

### 1. Abstract Factory Básico

```java
// Produtos abstratos
public interface Button {
    void render();
    void onClick();
}

public interface Checkbox {
    void render();
    void toggle();
}

// Fábrica abstrata
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Produtos concretos
public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Renderizando botão Windows");
    }
    
    @Override
    public void onClick() {
        System.out.println("Click no botão Windows");
    }
}

public class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Renderizando checkbox Windows");
    }
    
    @Override
    public void toggle() {
        System.out.println("Alternando checkbox Windows");
    }
}

// Fábrica concreta
public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
    
    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
```

### 2. Abstract Factory com Temas

```java
public interface Theme {
    Color getPrimaryColor();
    Color getSecondaryColor();
    Font getFont();
}

public interface ThemeFactory {
    Button createButton();
    Panel createPanel();
    Theme getTheme();
}

public class DarkThemeFactory implements ThemeFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }
    
    @Override
    public Panel createPanel() {
        return new DarkPanel();
    }
    
    @Override
    public Theme getTheme() {
        return new DarkTheme();
    }
}
```

## Casos de Uso

### 1. Sistema de UI Cross-Platform

```java
public class Application {
    private GUIFactory factory;
    private Button button;
    private Checkbox checkbox;
    
    public Application(GUIFactory factory) {
        this.factory = factory;
    }
    
    public void createUI() {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }
    
    public void paint() {
        button.render();
        checkbox.render();
    }
}

// Uso:
GUIFactory factory = new WindowsFactory();
Application app = new Application(factory);
app.createUI();
app.paint();
```

### 2. Sistema de Conexões de Banco de Dados

```java
public interface Connection {
    void connect();
    void query(String sql);
    void disconnect();
}

public interface Transaction {
    void begin();
    void commit();
    void rollback();
}

public interface DatabaseFactory {
    Connection createConnection();
    Transaction createTransaction();
}

public class MySQLFactory implements DatabaseFactory {
    @Override
    public Connection createConnection() {
        return new MySQLConnection();
    }
    
    @Override
    public Transaction createTransaction() {
        return new MySQLTransaction();
    }
}
```

## Melhores Práticas

1. **Coesão de Família**
   - Mantenha produtos relacionados juntos
   - Garanta compatibilidade entre produtos
   - Evite misturar famílias diferentes

2. **Extensibilidade**
   - Facilite a adição de novas famílias
   - Mantenha interfaces consistentes
   - Use composição sobre herança

3. **Configuração**
   - Permita seleção dinâmica de fábricas
   - Use injeção de dependência
   - Implemente factory method quando necessário

## Anti-Patterns

- Fábricas com responsabilidades misturadas
- Produtos incompatíveis entre famílias
- Lógica de negócio nas fábricas
- Hierarquias muito profundas

## Exercício Prático

Implemente um sistema de documentos com diferentes estilos:

```java
public interface DocumentFactory {
    Header createHeader();
    Body createBody();
    Footer createFooter();
}

public class ModernDocumentFactory implements DocumentFactory {
    @Override
    public Header createHeader() {
        return new ModernHeader();
    }
    
    @Override
    public Body createBody() {
        return new ModernBody();
    }
    
    @Override
    public Footer createFooter() {
        return new ModernFooter();
    }
}
```

## Próximos Passos

- Explore combinações com outros padrões
- Implemente em projetos reais
- Estude variações do padrão
- Pratique com diferentes cenários
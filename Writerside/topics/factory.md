# Factory Method Pattern

## Visão Geral

O Factory Method é um padrão criacional que define uma interface para criar objetos, mas permite que as subclasses decidam qual classe instanciar.

```ascii
FACTORY METHOD
├── Creator (Interface/Abstract)
├── Concrete Creator
├── Product (Interface)
└── Concrete Product
```

## Implementações

### 1. Factory Method Básico

```java
public interface Animal {
    void makeSound();
}

public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

public class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

public class AnimalFactory {
    public Animal createAnimal(String type) {
        return switch (type.toLowerCase()) {
            case "dog" -> new Dog();
            case "cat" -> new Cat();
            default -> throw new IllegalArgumentException("Unknown animal type");
        };
    }
}
```

### 2. Factory Method com Creator Abstrato

```java
public abstract class DocumentCreator {
    public abstract Document createDocument();
    
    public Document processDocument() {
        Document doc = createDocument();
        doc.process();
        return doc;
    }
}

public class PDFCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new PDFDocument();
    }
}

public class WordCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
```

### 3. Factory Method Parametrizado

```java
public class VehicleFactory {
    public Vehicle createVehicle(VehicleType type, String model) {
        return switch (type) {
            case CAR -> new Car(model);
            case TRUCK -> new Truck(model);
            case MOTORCYCLE -> new Motorcycle(model);
        };
    }
    
    public enum VehicleType {
        CAR, TRUCK, MOTORCYCLE
    }
}
```

## Casos de Uso

### 1. Sistema de Notificações

```java
public interface Notification {
    void send(String message);
}

public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        // Enviar email
    }
}

public class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        // Enviar SMS
    }
}

public class NotificationFactory {
    public Notification createNotification(String channel) {
        return switch (channel.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SMSNotification();
            default -> throw new IllegalArgumentException("Unknown channel");
        };
    }
}
```

### 2. Conexões de Banco de Dados

```java
public interface DatabaseConnection {
    void connect();
    void query(String sql);
}

public class MySQLConnection implements DatabaseConnection {
    @Override
    public void connect() {
        // Conectar ao MySQL
    }
    
    @Override
    public void query(String sql) {
        // Executar query MySQL
    }
}

public class ConnectionFactory {
    public DatabaseConnection createConnection(String type) {
        return switch (type.toLowerCase()) {
            case "mysql" -> new MySQLConnection();
            case "postgresql" -> new PostgreSQLConnection();
            default -> throw new IllegalArgumentException("Unknown database type");
        };
    }
}
```

## Melhores Práticas

1. **Design Claro**
   - Mantenha a hierarquia de classes simples
   - Use nomes descritivos
   - Documente o comportamento esperado

2. **Extensibilidade**
   - Facilite a adição de novos produtos
   - Use enums para tipos válidos
   - Considere configuração externa

3. **Tratamento de Erros**
   - Valide parâmetros de entrada
   - Use exceções específicas
   - Forneça mensagens de erro claras

## Anti-Patterns

- Factories muito complexas
- Lógica de negócio nas factories
- Duplicação de código entre produtos
- Factories não extensíveis

## Exercício Prático

Implemente um sistema de plugins usando Factory Method:

```java
public interface Plugin {
    void initialize();
    void execute();
    void shutdown();
}

public abstract class PluginFactory {
    public abstract Plugin createPlugin();
    
    public Plugin loadPlugin() {
        Plugin plugin = createPlugin();
        plugin.initialize();
        return plugin;
    }
}

public class ImagePluginFactory extends PluginFactory {
    @Override
    public Plugin createPlugin() {
        return new ImagePlugin();
    }
}

public class AudioPluginFactory extends PluginFactory {
    @Override
    public Plugin createPlugin() {
        return new AudioPlugin();
    }
}
```

## Próximos Passos

- Explore Abstract Factory
- Estude combinações com outros padrões
- Pratique com diferentes cenários
- Aprenda sobre Dependency Injection
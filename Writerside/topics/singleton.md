# Singleton Pattern

## Visão Geral

O Singleton é um padrão criacional que garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso a ela.

```ascii
SINGLETON PATTERN
├── Única Instância
├── Acesso Global
├── Lazy Loading
└── Thread Safety
```

## Implementações

### 1. Implementação Básica

```java
public class BasicSingleton {
    private static BasicSingleton instance;
    
    private BasicSingleton() {}
    
    public static BasicSingleton getInstance() {
        if (instance == null) {
            instance = new BasicSingleton();
        }
        return instance;
    }
}
```

### 2. Thread-Safe com Double-Check Locking

```java
public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton() {}
    
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
```

### 3. Inicialização Estática (Holder Pattern)

```java
public class HolderSingleton {
    private HolderSingleton() {}
    
    private static class Holder {
        static final HolderSingleton INSTANCE = new HolderSingleton();
    }
    
    public static HolderSingleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

### 4. Enum Singleton

```java
public enum EnumSingleton {
    INSTANCE;
    
    private Connection connection;
    
    EnumSingleton() {
        connection = DatabaseConnection.create();
    }
    
    public void execute(String sql) {
        connection.execute(sql);
    }
}
```

## Casos de Uso

1. **Conexões de Banco de Dados**
```java
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private final Connection connection;
    
    private DatabaseConnection() {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db");
    }
    
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
```

2. **Cache Global**
```java
public class GlobalCache {
    private static final GlobalCache INSTANCE = new GlobalCache();
    private Map<String, Object> cache = new ConcurrentHashMap<>();
    
    private GlobalCache() {}
    
    public static GlobalCache getInstance() {
        return INSTANCE;
    }
    
    public void put(String key, Object value) {
        cache.put(key, value);
    }
    
    public Object get(String key) {
        return cache.get(key);
    }
}
```

## Melhores Práticas

1. **Escolha a Implementação Adequada**
   - Use Holder Pattern para lazy loading thread-safe
   - Use Enum para serialização garantida
   - Use Double-Check Locking apenas se necessário

2. **Evite Estado Mutável**
   - Minimize o estado interno
   - Use imutabilidade quando possível
   - Considere thread safety

3. **Teste Adequadamente**
   - Verifique thread safety
   - Teste serialização
   - Valide comportamento em diferentes cenários

## Anti-Patterns

- Uso excessivo de Singletons
- Singletons com muito estado
- Acoplamento forte com Singletons
- Singletons não thread-safe

## Exercício Prático

Implemente um gerenciador de configurações usando Singleton:

```java
public class ConfigManager {
    private static volatile ConfigManager instance;
    private Properties config;
    
    private ConfigManager() {
        config = new Properties();
        loadConfig();
    }
    
    public static ConfigManager getInstance() {
        if (instance == null) {
            synchronized (ConfigManager.class) {
                if (instance == null) {
                    instance = new ConfigManager();
                }
            }
        }
        return instance;
    }
    
    private void loadConfig() {
        try (InputStream input = getClass().getClassLoader()
                .getResourceAsStream("config.properties")) {
            config.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading config", e);
        }
    }
    
    public String getProperty(String key) {
        return config.getProperty(key);
    }
}
```

## Próximos Passos

- Explore outros padrões criacionais
- Estude alternativas ao Singleton
- Pratique com diferentes implementações
- Aprenda sobre injeção de dependências
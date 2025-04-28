# Builder Pattern

## Visão Geral

O Builder é um padrão criacional que permite construir objetos complexos passo a passo, separando o processo de construção da representação final.

```ascii
BUILDER PATTERN
├── Director (Opcional)
├── Builder (Interface)
├── Concrete Builder
└── Product
```

## Implementações

### 1. Builder Clássico

```java
public class Pizza {
    private String dough;
    private String sauce;
    private String topping;
    
    public static class Builder {
        private Pizza pizza = new Pizza();
        
        public Builder dough(String dough) {
            pizza.dough = dough;
            return this;
        }
        
        public Builder sauce(String sauce) {
            pizza.sauce = sauce;
            return this;
        }
        
        public Builder topping(String topping) {
            pizza.topping = topping;
            return this;
        }
        
        public Pizza build() {
            return pizza;
        }
    }
}

// Uso:
Pizza pizza = new Pizza.Builder()
    .dough("thin")
    .sauce("tomato")
    .topping("cheese")
    .build();
```

### 2. Builder com Director

```java
public interface HouseBuilder {
    void buildFoundation();
    void buildWalls();
    void buildRoof();
    House getResult();
}

public class ConcreteHouseBuilder implements HouseBuilder {
    private House house = new House();
    
    @Override
    public void buildFoundation() {
        house.setFoundation("Concrete Foundation");
    }
    
    @Override
    public void buildWalls() {
        house.setWalls("Brick Walls");
    }
    
    @Override
    public void buildRoof() {
        house.setRoof("Tile Roof");
    }
    
    @Override
    public House getResult() {
        return house;
    }
}

public class HouseDirector {
    private HouseBuilder builder;
    
    public HouseDirector(HouseBuilder builder) {
        this.builder = builder;
    }
    
    public void constructHouse() {
        builder.buildFoundation();
        builder.buildWalls();
        builder.buildRoof();
    }
}
```

### 3. Builder com Validação

```java
public class User {
    private final String username;
    private final String email;
    private final int age;
    
    private User(Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.age = builder.age;
    }
    
    public static class Builder {
        private String username;
        private String email;
        private int age;
        
        public Builder username(String username) {
            if (username == null || username.trim().isEmpty()) {
                throw new IllegalArgumentException("Username is required");
            }
            this.username = username;
            return this;
        }
        
        public Builder email(String email) {
            if (!email.contains("@")) {
                throw new IllegalArgumentException("Invalid email");
            }
            this.email = email;
            return this;
        }
        
        public Builder age(int age) {
            if (age < 0 || age > 150) {
                throw new IllegalArgumentException("Invalid age");
            }
            this.age = age;
            return this;
        }
        
        public User build() {
            validateUserData();
            return new User(this);
        }
        
        private void validateUserData() {
            // Validação complexa
        }
    }
}
```

## Casos de Uso

### 1. Construtor de Documentos

```java
public class Document {
    private List<String> headers = new ArrayList<>();
    private List<String> body = new ArrayList<>();
    private List<String> footers = new ArrayList<>();
    
    public static class Builder {
        private Document doc = new Document();
        
        public Builder addHeader(String header) {
            doc.headers.add(header);
            return this;
        }
        
        public Builder addBodyParagraph(String paragraph) {
            doc.body.add(paragraph);
            return this;
        }
        
        public Builder addFooter(String footer) {
            doc.footers.add(footer);
            return this;
        }
        
        public Document build() {
            return doc;
        }
    }
}
```

### 2. Construtor de Queries SQL

```java
public class SQLQueryBuilder {
    private StringBuilder query = new StringBuilder();
    private boolean hasWhere = false;
    private List<String> conditions = new ArrayList<>();
    
    public SQLQueryBuilder select(String... columns) {
        query.append("SELECT ");
        query.append(String.join(", ", columns));
        return this;
    }
    
    public SQLQueryBuilder from(String table) {
        query.append(" FROM ").append(table);
        return this;
    }
    
    public SQLQueryBuilder where(String condition) {
        if (!hasWhere) {
            query.append(" WHERE ");
            hasWhere = true;
        } else {
            query.append(" AND ");
        }
        query.append(condition);
        return this;
    }
    
    public String build() {
        return query.toString();
    }
}
```

## Melhores Práticas

1. **Imutabilidade**
   - Use campos finais
   - Valide no momento da construção
   - Retorne cópias defensivas

2. **Validação**
   - Valide parâmetros individuais
   - Faça validação cruzada
   - Lance exceções apropriadas

3. **Fluência**
   - Use method chaining
   - Nomeie métodos claramente
   - Mantenha consistência

## Anti-Patterns

- Builders mutáveis
- Validação insuficiente
- Complexidade desnecessária
- Violação do princípio de responsabilidade única

## Exercício Prático

Implemente um builder para configuração de conexão de banco de dados:

```java
public class DatabaseConfig {
    private final String host;
    private final int port;
    private final String database;
    private final String username;
    private final String password;
    private final boolean useSSL;
    private final int timeout;
    
    public static class Builder {
        private String host = "localhost";
        private int port = 5432;
        private String database;
        private String username;
        private String password;
        private boolean useSSL = false;
        private int timeout = 30;
        
        public Builder host(String host) {
            this.host = host;
            return this;
        }
        
        public Builder port(int port) {
            this.port = port;
            return this;
        }
        
        // ... outros setters
        
        public DatabaseConfig build() {
            validate();
            return new DatabaseConfig(this);
        }
        
        private void validate() {
            if (database == null || username == null || password == null) {
                throw new IllegalStateException("Database, username and password are required");
            }
            if (port < 0 || port > 65535) {
                throw new IllegalArgumentException("Invalid port number");
            }
            if (timeout <= 0) {
                throw new IllegalArgumentException("Timeout must be positive");
            }
        }
    }
    
    private DatabaseConfig(Builder builder) {
        this.host = builder.host;
        this.port = builder.port;
        this.database = builder.database;
        this.username = builder.username;
        this.password = builder.password;
        this.useSSL = builder.useSSL;
        this.timeout = builder.timeout;
    }
}
```

## Próximos Passos

- Explore variações do Builder
- Combine com outros padrões
- Estude builders em frameworks
- Pratique com casos complexos
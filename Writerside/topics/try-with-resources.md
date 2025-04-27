# Try-with-Resources em Java

## Introdução
Try-with-resources é um recurso introduzido no Java 7 que simplifica o gerenciamento de recursos que precisam ser fechados após o uso.

## Sintaxe Básica

```java
try (Resource resource = new Resource()) {
    // uso do recurso
} catch (Exception e) {
    // tratamento de exceção
}
```

## Recursos AutoCloseable

### Interface AutoCloseable
```java
public interface AutoCloseable {
    void close() throws Exception;
}
```

### Implementação Básica
```java
public class MyResource implements AutoCloseable {
    public MyResource() {
        System.out.println("Recurso criado");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Recurso fechado");
    }
}
```

## Comparação com Try-Catch-Finally Tradicional

### Antes (Try-Catch-Finally)
```java
FileReader reader = null;
try {
    reader = new FileReader("file.txt");
    // usar reader
} catch (IOException e) {
    // tratamento de erro
} finally {
    if (reader != null) {
        try {
            reader.close();
        } catch (IOException e) {
            // tratamento de erro ao fechar
        }
    }
}
```

### Depois (Try-with-Resources)
```java
try (FileReader reader = new FileReader("file.txt")) {
    // usar reader
} catch (IOException e) {
    // tratamento de erro
}
```

## Múltiplos Recursos

### Gerenciando Vários Recursos
```java
try (FileInputStream input = new FileInputStream("input.txt");
     FileOutputStream output = new FileOutputStream("output.txt")) {
    // usar input e output
    byte[] buffer = new byte[1024];
    int length;
    while ((length = input.read(buffer)) > 0) {
        output.write(buffer, 0, length);
    }
}
```

## Exemplos Práticos

### Exemplo 1: Processamento de Arquivo
```java
public class FileProcessor {
    public List<String> readLines(String path) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
}
```

### Exemplo 2: Operações de Banco de Dados
```java
public class DatabaseOperations {
    public void transferMoney(int fromAccount, int toAccount, double amount) {
        try (Connection conn = getConnection();
             PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
             PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?")) {
            
            conn.setAutoCommit(false);
            
            debit.setDouble(1, amount);
            debit.setInt(2, fromAccount);
            debit.executeUpdate();
            
            credit.setDouble(1, amount);
            credit.setInt(2, toAccount);
            credit.executeUpdate();
            
            conn.commit();
        }
    }
}
```

## Recursos Personalizados

### Criando Recurso Personalizado
```java
public class DatabaseConnection implements AutoCloseable {
    private final Connection connection;
    
    public DatabaseConnection(String url) throws SQLException {
        this.connection = DriverManager.getConnection(url);
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    @Override
    public void close() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
```

### Usando Recurso Personalizado
```java
public class CustomResourceExample {
    public void useCustomResource() {
        try (DatabaseConnection db = new DatabaseConnection("jdbc:mysql://localhost/db")) {
            Connection conn = db.getConnection();
            // usar conexão
        } catch (Exception e) {
            // tratamento de erro
        }
    }
}
```

## Boas Práticas

1. **Sempre Use para Recursos AutoCloseable**
```java
// Bom
try (InputStream in = new FileInputStream("file.txt")) {
    // código
}

// Evite
InputStream in = new FileInputStream("file.txt");
try {
    // código
} finally {
    in.close();
}
```

2. **Ordem de Fechamento**
```java
try (ResourceOne one = new ResourceOne();
     ResourceTwo two = new ResourceTwo()) {
    // Os recursos são fechados na ord
# Try-Catch e Finally em Java

## Estrutura Básica

```java
try {
    // Código que pode lançar exceção
} catch (ExceptionType e) {
    // Tratamento da exceção
} finally {
    // Código que sempre executa
}
```

## Blocos Try-Catch

### Try Block
- Contém código que pode lançar exceções
- Pode conter múltiplas linhas
- Deve ser seguido por catch ou finally

```java
try {
    int result = 10 / 0;  // Lança ArithmeticException
    System.out.println(result);
}
```

### Catch Block
- Captura e trata exceções específicas
- Pode ter múltiplos blocos catch
- Deve ser ordenado do mais específico para o mais genérico

```java
try {
    // código arriscado
} catch (ArithmeticException e) {
    System.out.println("Erro de divisão: " + e.getMessage());
} catch (Exception e) {
    System.out.println("Erro genérico: " + e.getMessage());
}
```

### Finally Block
- Sempre executa, independente de exceção
- Útil para limpeza de recursos
- Opcional, mas importante para boas práticas

```java
FileReader reader = null;
try {
    reader = new FileReader("file.txt");
    // processar arquivo
} catch (IOException e) {
    System.out.println("Erro ao ler arquivo");
} finally {
    if (reader != null) {
        try {
            reader.close();
        } catch (IOException e) {
            // handle close exception
        }
    }
}
```

## Padrões Comuns

### 1. Múltiplos Catch
```java
try {
    // código arriscado
} catch (FileNotFoundException e) {
    // tratamento específico para arquivo não encontrado
} catch (IOException e) {
    // tratamento para outros erros de I/O
} catch (Exception e) {
    // tratamento para qualquer outra exceção
}
```

### 2. Multi-catch (Java 7+)
```java
try {
    // código arriscado
} catch (IOException | SQLException e) {
    // tratamento comum para ambas exceções
}
```

### 3. Rethrow
```java
try {
    // código arriscado
} catch (Exception e) {
    // log do erro
    logger.error("Erro durante processamento", e);
    throw e; // relança a exceção
}
```

## Boas Práticas

1. **Seja Específico**
```java
// Ruim
try {
    // código
} catch (Exception e) { }

// Bom
try {
    // código
} catch (FileNotFoundException e) {
    // tratamento específico
}
```

2. **Log Adequado**
```java
try {
    // código
} catch (Exception e) {
    logger.error("Contexto do erro: " + e.getMessage(), e);
}
```

3. **Limpeza de Recursos**
```java
Connection conn = null;
try {
    conn = getConnection();
    // usar conexão
} finally {
    if (conn != null) {
        conn.close();
    }
}
```

## Exemplos Práticos

### Exemplo 1: Processamento de Arquivo
```java
public class FileProcessor {
    public void processFile(String path) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + path);
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar arquivo");
                }
            }
        }
    }
}
```

### Exemplo 2: Operações de Banco de Dados
```java
public class DatabaseOperations {
    public void updateRecord(int id, String data) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("UPDATE records SET data = ? WHERE id = ?");
            stmt.setString(1, data);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados: " + e.getMessage());
        } finally {
            closeResources(conn, stmt);
        }
    }
}
```

## Próximos Passos
- Aprenda sobre [Try-with-Resources](try-with-resources.md)
- Explore [Exceções Personalizadas](custom-exceptions.md)
- Pratique com diferentes tipos de exceções

## Recursos Adicionais
- [Java Exception Handling Tutorial](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
- [Best Practices for Exception Handling](https://www.oracle.com/java/technologies/javase/exceptions.html)
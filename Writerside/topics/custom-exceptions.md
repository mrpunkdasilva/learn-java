# Exceções Personalizadas em Java

## Introdução
Exceções personalizadas permitem criar tipos específicos de erro para seu domínio de negócio, tornando o código mais expressivo e manutenível.

## Criando Exceções Personalizadas

### Exceção Verificada (Checked)
```java
public class BusinessException extends Exception {
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

### Exceção Não Verificada (Unchecked)
```java
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

## Padrões Comuns

### 1. Exceções de Domínio
```java
public class UserNotFoundException extends RuntimeException {
    private final String userId;

    public UserNotFoundException(String userId) {
        super("Usuário não encontrado: " + userId);
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
```

### 2. Exceções com Dados Adicionais
```java
public class OrderProcessingException extends Exception {
    private final String orderId;
    private final OrderStatus status;

    public OrderProcessingException(String message, String orderId, OrderStatus status) {
        super(message);
        this.orderId = orderId;
        this.status = status;
    }

    // Getters para informações adicionais
    public String getOrderId() { return orderId; }
    public OrderStatus getStatus() { return status; }
}
```

## Exemplos de Uso

### Exemplo 1: Validação de Negócio
```java
public class UserService {
    public void createUser(User user) throws ValidationException {
        if (user.getAge() < 18) {
            throw new ValidationException("Usuário deve ser maior de idade");
        }
        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            throw new ValidationException("Email inválido");
        }
        // Continua processamento
    }
}
```

### Exemplo 2: Processamento de Pedidos
```java
public class OrderProcessor {
    public void processOrder(Order order) throws OrderProcessingException {
        try {
            validateOrder(order);
            calculateTotal(order);
            saveOrder(order);
        } catch (Exception e) {
            throw new OrderProcessingException(
                "Erro ao processar pedido",
                order.getId(),
                order.getStatus()
            );
        }
    }
}
```

## Boas Práticas

1. **Nomeação Clara**
```java
// Bom
public class InvalidPasswordException extends RuntimeException { }

// Ruim
public class PasswordException extends RuntimeException { }
```

2. **Informações Relevantes**
```java
public class DatabaseConnectionException extends Exception {
    public DatabaseConnectionException(String server, int port, Throwable cause) {
        super(String.format("Falha ao conectar ao servidor %s:%d", server, port), cause);
    }
}
```

3. **Hierarquia Apropriada**
```java
// Exceção base para o módulo
public abstract class PaymentException extends Exception { }

// Exceções específicas
public class PaymentDeclinedException extends PaymentException { }
public class InsufficientFundsException extends PaymentException { }
```

## Exemplos Práticos

### Sistema de Pagamento
```java
public class PaymentProcessor {
    public void processPayment(Payment payment) throws PaymentException {
        try {
            validatePayment(payment);
            executeTransaction(payment);
            notifySuccess(payment);
        } catch (ValidationException e) {
            throw new PaymentValidationException("Pagamento inválido", e);
        } catch (TransactionException e) {
            throw new PaymentProcessingException("Erro na transação", e);
        }
    }
}
```

### Sistema de Arquivos
```java
public class FileManager {
    public void saveDocument(Document doc) throws DocumentException {
        if (!isValidDocument(doc)) {
            throw new InvalidDocumentException("Documento inválido");
        }
        
        try {
            writeToFile(doc);
        } catch (IOException e) {
            throw new DocumentStorageException("Erro ao salvar documento", e);
        }
    }
}
```

## Próximos Passos
- Identifique casos de uso para exceções personalizadas em seu código
- Crie hierarquias de exceção para seu domínio
- Implemente tratamento adequado para suas exceções

## Recursos Adicionais
- [Java Exception Handling Best Practices](https://www.oracle.com/java/technologies/javase/exceptions.html)
- [Design Guidelines for Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/design.html)
# Tipos de Referência

```ascii
REFERENCE TYPES
├── Classes
├── Interfaces
├── Arrays
└── Enums
```

## Classes

### Definição e Uso
```java
// Declaração
String mensagem = new String("Conexão estabelecida");
StringBuilder buffer = new StringBuilder();

// Null é permitido
String dados = null;
```

### Classes Comuns
```java
// Wrapper classes
Integer numero = 42;
Double valor = 3.14;
Boolean flag = true;

// Utilitários
Date data = new Date();
Random gerador = new Random();
```

## Arrays

### Declaração e Inicialização
```java
// Arrays unidimensionais
int[] numeros = new int[5];
String[] comandos = {"LOGIN", "EXECUTE", "LOGOUT"};

// Arrays multidimensionais
int[][] matriz = new int[3][3];
```

### Manipulação
```java
// Acessando elementos
int primeiro = numeros[0];

// Modificando elementos
numeros[1] = 42;

// Comprimento
int tamanho = numeros.length;
```

## Enums

### Definição
```java
public enum NivelAcesso {
    ADMIN,
    USUARIO,
    CONVIDADO
}
```

### Uso
```java
NivelAcesso nivel = NivelAcesso.ADMIN;

switch (nivel) {
    case ADMIN:
        System.out.println("Acesso total");
        break;
    case USUARIO:
        System.out.println("Acesso parcial");
        break;
    case CONVIDADO:
        System.out.println("Acesso limitado");
        break;
}
```

## Interfaces

### Implementação
```java
public interface Conexao {
    void conectar();
    void desconectar();
}

public class ConexaoSegura implements Conexao {
    @Override
    public void conectar() {
        // Implementação
    }

    @Override
    public void desconectar() {
        // Implementação
    }
}
```

## Diferenças dos Primitivos

### Características
```ascii
REFERENCE VS PRIMITIVE
├── Armazenamento (Heap vs Stack)
├── Null permitido
├── Métodos disponíveis
└── Overhead de memória
```

### Exemplo
```java
// Primitivo
int x = 10;

// Referência
Integer y = 10;
y.toString(); // Métodos disponíveis
y = null; // Permitido
```

## Garbage Collection

### Ciclo de Vida
```ascii
OBJECT LIFECYCLE
├── Criação (new)
├── Referenciação
├── Desreferenciação
└── Coleta de lixo
```

### Exemplo
```java
String texto = new String("temp"); // Objeto criado
texto = null; // Objeto elegível para GC
```

## Collections Framework

### Tipos Principais
```java
// List
List<String> lista = new ArrayList<>();

// Set
Set<Integer> conjunto = new HashSet<>();

// Map
Map<String, Integer> mapa = new HashMap<>();
```

## Boas Práticas

### Recomendações
```ascii
BEST PRACTICES
├── Inicialize referências
├── Use interfaces apropriadas
├── Verifique null
└── Libere recursos
```

### Exemplo
```java
// Verificação de null
if (objeto != null) {
    objeto.metodo();
}

// Try-with-resources
try (Scanner scanner = new Scanner(System.in)) {
    // Uso do scanner
}
```

## Próximos Passos

### Tópicos Relacionados
- [Type Casting](type-casting.md)
- [Palavra-chave var](var-keyword.md)
- [Collections](collections-overview.md)

[Type Casting](type-casting.md){.next-step}

---

> "Os tipos de referência são como os programas da Matrix - entidades complexas que manipulam a realidade digital."
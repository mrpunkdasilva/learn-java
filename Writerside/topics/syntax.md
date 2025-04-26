# Sintaxe Java

```ascii
SYNTAX STRUCTURE
├── Declarações
├── Blocos
├── Expressões
└── Statements
```

## Estrutura Básica

### Classe
```java
public class MatrixCode {
    // Membros da classe aqui
}
```

### Método
```java
public void hackSystem() {
    // Código do método aqui
}
```

## Declarações

### Variáveis
```java
// Declaração simples
tipo nome;

// Declaração com inicialização
tipo nome = valor;

// Exemplos
int contador = 0;
String mensagem = "Conexão estabelecida";
boolean sistemaBloqueado = false;
```

### Constantes
```java
// Constante
final double PI = 3.14159;

// Constante estática
public static final String VERSION = "1.0.0";
```

## Blocos de Código

### Estrutura
```java
{
    // Bloco de código
    // Pode conter múltiplas linhas
}
```

### Escopo
```java
public void exemplo() {
    int x = 1; // Escopo do método
    {
        int y = 2; // Escopo do bloco
        // y é acessível aqui
    }
    // y não é acessível aqui
    // x é acessível em todo o método
}
```

## Statements

### Tipos
```java
// Statement simples
System.out.println("Executando...");

// Statement composto
if (status == "online") {
    System.out.println("Conectado");
    iniciarOperacao();
}
```

## Expressões

### Componentes
```java
// Expressões aritméticas
resultado = 10 + 5 * 2;

// Expressões lógicas
boolean acessoPermitido = nivel >= 5 && !bloqueado;

// Expressões de string
String nomeCompleto = nome + " " + sobrenome;
```

## Identificadores

### Regras
```ascii
IDENTIFIER RULES
├── Começar com letra, $ ou _
├── Pode conter números
├── Case-sensitive
└── Sem palavras reservadas
```

### Exemplos
```java
// Válidos
String usuarioNome;
int _contador;
double $taxa;

// Inválidos
int 123numero;     // Começa com número
String class;      // Palavra reservada
```

## Palavras Reservadas

### Keywords
```ascii
RESERVED WORDS
├── Tipos      (boolean, byte, char...)
├── Controle   (if, else, for, while...)
├── Acesso     (public, private, protected...)
└── Outros     (new, return, this, super...)
```

## Separadores

### Caracteres Especiais
```ascii
SEPARATORS
├── { }    Blocos
├── [ ]    Arrays
├── ( )    Parâmetros
├── ;      Fim de statement
├── ,      Separador
└── .      Acesso a membros
```

## Convenções

### Estilo de Código
```ascii
CODE STYLE
├── Classes        PascalCase
├── Métodos        camelCase
├── Variáveis      camelCase
├── Constantes     UPPER_SNAKE_CASE
└── Pacotes        lowercase
```

## Exemplos Práticos

### Classe Completa
```java
package com.netrunner.core;

public class SecuritySystem {
    private static final int MAX_ATTEMPTS = 3;
    private int attemptCount;
    
    public SecuritySystem() {
        this.attemptCount = 0;
    }
    
    public boolean authenticate(String code) {
        attemptCount++;
        if (attemptCount > MAX_ATTEMPTS) {
            lockSystem();
            return false;
        }
        return validateCode(code);
    }
    
    private void lockSystem() {
        System.out.println("Sistema bloqueado!");
    }
    
    private boolean validateCode(String code) {
        return code.equals("MATRIX_1999");
    }
}
```

## Próximos Passos

### Tópicos Relacionados
- [Variáveis](variables.md)
- [Operadores](operators.md)
- [Estruturas de Controle](control-flow.md)

[Variáveis](variables.md){.next-step}

---

> "A sintaxe é o protocolo que mantém a Matrix funcionando. Domine-a, e você dominará o sistema."
# Variáveis em Java

```ascii
VARIABLES
├── Tipos Primitivos
├── Tipos de Referência
├── Type Casting
└── Palavra-chave var
```

## Conceitos Básicos

### Definição
Uma variável é um local na memória que armazena dados. Em Java, toda variável tem:
- Nome (identificador)
- Tipo
- Valor

### Declaração
```java
// Sintaxe básica
tipoDaVariavel nomeDaVariavel;

// Com inicialização
tipoDaVariavel nomeDaVariavel = valor;
```

## Categorias Principais

### Tipos Primitivos
```ascii
PRIMITIVE TYPES
├── Números Inteiros (byte, short, int, long)
├── Números Decimais (float, double)
├── Caractere (char)
└── Booleano (boolean)
```

### Tipos de Referência
```ascii
REFERENCE TYPES
├── Classes
├── Interfaces
├── Arrays
└── Enums
```

## Escopo

### Níveis
```ascii
SCOPE LEVELS
├── Classe (campos)
├── Método (variáveis locais)
└── Bloco (variáveis de bloco)
```

### Exemplo
```java
public class DataMatrix {
    private int nivelAcesso; // Escopo de classe
    
    public void processarDados() {
        int contador = 0; // Escopo de método
        
        for (int i = 0; i < 10; i++) { // i tem escopo de bloco
            // código aqui
        }
    }
}
```

## Modificadores

### Constantes
```java
// Constante de classe
public static final int MAX_CONEXOES = 100;

// Constante local
final double PI = 3.14159;
```

### Variáveis Estáticas
```java
public class Sistema {
    static int contadorGlobal; // Compartilhada por todas instâncias
    int contadorLocal; // Específica para cada instância
}
```

## Boas Práticas

### Nomenclatura
```java
// Bom
int userId;
String firstName;
boolean isActive;

// Evitar
int a;
String x;
boolean flag;
```

### Inicialização
```java
// Valores padrão
int numero; // 0
boolean status; // false
String texto; // null

// Inicialização explícita (recomendado)
int numero = 0;
boolean status = false;
String texto = "";
```

## Subseções

- [Tipos Primitivos](primitive-types.md)
- [Tipos de Referência](reference-types.md)
- [Type Casting](type-casting.md)
- [Palavra-chave var](var-keyword.md)

[Tipos Primitivos](primitive-types.md){.next-step}

---

> "Variáveis são como terminais na Matrix - pontos de acesso para manipular a realidade digital."
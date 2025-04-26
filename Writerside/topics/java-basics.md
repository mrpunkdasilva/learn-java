# Fundamentos Java

```ascii
JAVA BASICS
├── Estrutura
├── Sintaxe
├── Tipos
├── Operadores
└── Strings
```

## Estrutura de um Programa

### Anatomia Básica
```java
// Arquivo: HelloMatrix.java
public class HelloMatrix {
    public static void main(String[] args) {
        System.out.println("Iniciando conexão com a Matrix...");
    }
}
```

### Componentes Principais
```ascii
JAVA STRUCTURE
├── Package Declaration
├── Imports
├── Class Declaration
├── Fields
└── Methods
```

## Convenções de Código

### Nomenclatura
```ascii
NAMING CONVENTIONS
├── Classes        (PascalCase)
├── Methods        (camelCase)
├── Variables      (camelCase)
├── Constants      (UPPER_SNAKE_CASE)
└── Packages       (lowercase)
```

## Compilação e Execução

### Processo
```ascii
COMPILATION FLOW
Source (.java) → Bytecode (.class) → JVM → Execution
```

### Comandos
```bash
# Compilar
javac HelloMatrix.java

# Executar
java HelloMatrix
```

## Estrutura de Arquivos

### Organização
```ascii
PROJECT STRUCTURE
src/
├── com/
│   └── netrunner/
│       └── core/
│           └── HelloMatrix.java
└── resources/
    └── config.properties
```

## Comentários

### Tipos
```java
// Comentário de linha única

/*
   Comentário de
   múltiplas linhas
*/

/**
 * Documentação JavaDoc
 * @author NetRunner
 * @version 1.0
 */
```

## Palavras-Chave

### Keywords Principais
```ascii
KEYWORDS
├── Controle     (if, else, for, while)
├── Modificadores (public, private, static)
├── Tipos        (class, interface, enum)
└── Outros       (new, return, this, super)
```

## Ambiente de Desenvolvimento

### Ferramentas Essenciais
```ascii
DEV ENVIRONMENT
├── JDK
├── IDE
├── Build Tools
└── Version Control
```

## Debug e Logs

### Técnicas Básicas
```java
// Print debugging
System.out.println("Debug: " + variable);

// Logging básico
Logger logger = Logger.getLogger(HelloMatrix.class.getName());
logger.info("Iniciando aplicação...");
```

## Boas Práticas

### Princípios
```ascii
BEST PRACTICES
├── Clean Code
├── DRY (Don't Repeat Yourself)
├── KISS (Keep It Simple)
└── SOLID Principles
```

## Próximos Passos

### Tópicos Seguintes
- Sintaxe detalhada
- Variáveis e tipos
- Operadores
- Strings e manipulação
- Projetos práticos

[Sintaxe Java](syntax.md){.next-step}

---

> "Java é como o código base da Matrix - estruturado, robusto e onipresente."

## Subseções

- [Sintaxe](syntax.md)
- [Variáveis](variables.md)
- [Operadores](operators.md)
- [Strings](strings.md)
- [Projetos Básicos](basic-projects.md)
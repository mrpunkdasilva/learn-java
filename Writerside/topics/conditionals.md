# Estruturas Condicionais

```ascii
>> Inicializando sistema de decisão...
>> Carregando árvores lógicas...
>> Estabelecendo caminhos de execução...
```

## Visão Geral

As estruturas condicionais são como os checkpoints da Matrix - elas determinam quais caminhos seu código pode seguir.

## Estruturas Básicas

### 1. if-else

```java
if (condicao) {
    // código executado se verdadeiro
} else {
    // código executado se falso
}
```

#### Exemplo Prático
```java
int securityLevel = 5;
if (securityLevel >= 4) {
    System.out.println("Acesso concedido ao mainframe");
} else {
    System.out.println("Acesso negado");
}
```

### 2. else-if

```java
if (condicao1) {
    // código para condição 1
} else if (condicao2) {
    // código para condição 2
} else {
    // código padrão
}
```

#### Exemplo Prático
```java
int threatLevel = 3;
if (threatLevel == 1) {
    System.out.println("Alerta Verde");
} else if (threatLevel == 2) {
    System.out.println("Alerta Amarelo");
} else {
    System.out.println("Alerta Vermelho");
}
```

### 3. Operador Ternário

```java
resultado = (condicao) ? valorSeVerdadeiro : valorSeFalso;
```

#### Exemplo Prático
```java
int energia = 50;
String status = (energia > 20) ? "Online" : "Offline";
```

## Operadores de Comparação

| Operador | Descrição |
|----------|-----------|
| `==` | Igual a |
| `!=` | Diferente de |
| `>` | Maior que |
| `<` | Menor que |
| `>=` | Maior ou igual |
| `<=` | Menor ou igual |

## Operadores Lógicos

| Operador | Descrição |
|----------|-----------|
| `&&` | AND lógico |
| `\|\|` | OR lógico |
| `!` | NOT lógico |

## Boas Práticas

1. **Clareza nas Condições**
   ```java
   // Ruim
   if (x == 1 && y == 2 || z == 3 && !w) { }
   
   // Bom
   boolean isValidX = (x == 1);
   boolean isValidY = (y == 2);
   boolean isValidZ = (z == 3 && !w);
   if (isValidX && isValidY || isValidZ) { }
   ```

2. **Evite Aninhamento Excessivo**
   ```java
   // Evite
   if (a) {
       if (b) {
           if (c) {
               // código
           }
       }
   }
   
   // Prefira
   if (!a || !b || !c) return;
   // código
   ```

3. **Use Chaves Sempre**
   ```java
   // Evite
   if (condicao) comando;
   
   // Prefira
   if (condicao) {
       comando;
   }
   ```

## Padrões Avançados

### Switch Expression (Java 14+)
```java
String mensagem = switch (nivelAcesso) {
    case 1 -> "Acesso Básico";
    case 2 -> "Acesso Intermediário";
    case 3 -> "Acesso Total";
    default -> "Sem Acesso";
};
```

### Pattern Matching (Preview)
```java
if (obj instanceof String s && s.length() > 5) {
    System.out.println("String longa: " + s);
}
```

## Exercícios Práticos

1. **Sistema de Autenticação**
   ```java
   public boolean verificarAcesso(String usuario, int nivel) {
       if (usuario == null || usuario.isEmpty()) {
           return false;
       }
       return nivel >= 3 && usuario.startsWith("ADMIN_");
   }
   ```

2. **Validador de Status**
   ```java
   public String verificarStatus(int memoria, int cpu) {
       if (memoria < 10 || cpu > 90) {
           return "CRÍTICO";
       } else if (memoria < 30 || cpu > 70) {
           return "ALERTA";
       }
       return "NORMAL";
   }
   ```

## Próximos Passos

- Explore estruturas de repetição em [Loops](loops.md)
- Aprenda sobre expressões switch em [Switch Expressions](switch-expressions.md)
- Descubra pattern matching em [Pattern Matching](pattern-matching.md)

[Loops](loops.md){.next-step}
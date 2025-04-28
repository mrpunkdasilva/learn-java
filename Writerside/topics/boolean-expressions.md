# Expressões Booleanas

## Conceitos Básicos

### Definição
```java
// Expressões que resultam em true ou false
boolean resultado = (10 > 5);           // true
boolean composto = (x > 0 && y < 100);  // depende de x e y
```

## Operadores de Comparação

### Comparações Básicas
```java
// Igualdade e diferença
boolean igual = (valor == 10);      // true se valor for 10
boolean diferente = (valor != 20);  // true se valor não for 20

// Comparações numéricas
boolean maior = (contador > 100);    // true se contador maior que 100
boolean menorIgual = (total <= 50); // true se total menor ou igual a 50
```

## Operadores Lógicos

### Combinações Lógicas
```java
// AND (&&) - ambas condições verdadeiras
boolean aprovado = (nota >= 7.0 && frequencia >= 75);

// OR (||) - pelo menos uma condição verdadeira
boolean desconto = (isCliente || isPrimeiraCompra);

// NOT (!) - inverte o valor lógico
boolean invalido = !dadosValidos;
```

## Expressões Compostas

### Precedência de Operadores
```java
// Uso de parênteses para clareza
boolean complexo = (idade >= 18 && (temCNH || temAutorizacao));

// Múltiplas condições
boolean elegivel = (
    idade >= 18 &&
    rendaMinima >= 2000 &&
    !possuiRestricoes
);
```

## Boas Práticas

### Legibilidade
```java
// Evite negações múltiplas
boolean ruim = !!!ativo;            // Difícil de ler
boolean melhor = !ativo;            // Mais claro

// Quebre expressões complexas
boolean status = 
    verificarIdade() &&
    verificarDocumentos() &&
    verificarHistorico();
```

### Simplificação
```java
// Evite redundância
boolean redundante = (valor == true);    // Não faça isso
boolean correto = valor;                 // Melhor forma

// Simplifique expressões
boolean verboso = (idade >= 18) ? true : false;    // Redundante
boolean simples = idade >= 18;                     // Melhor
```

## Casos Comuns

### Validações
```java
// Verificação de strings
boolean stringValida = texto != null && !texto.isEmpty();

// Ranges numéricos
boolean dentroLimite = (valor >= minimo && valor <= maximo);

// Verificações de estado
boolean sistemaPronto = 
    bancoDados.conectado() &&
    cache.inicializado() &&
    !manutencao;
```

## Próximos Passos

### Tópicos Relacionados
- [Operadores Lógicos](logical.md)
- [Estruturas Condicionais](conditionals.md)
- [Controle de Fluxo](control-flow.md)

[Operadores Lógicos](logical.md){.next-step}
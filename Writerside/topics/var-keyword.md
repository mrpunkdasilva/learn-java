# Palavra-chave var

```ascii
VAR KEYWORD
├── Inferência de Tipo
├── Restrições
├── Usos Comuns
└── Boas Práticas
```

## Introdução

### O que é var?
```java
// Inferência de tipo local
var mensagem = "Conexão estabelecida";
var contador = 0;
var lista = new ArrayList<String>();
```

## Inferência de Tipo

### Como Funciona
```java
// O compilador infere o tipo
var numero = 42; // int
var texto = "Matrix"; // String
var decimal = 3.14; // double
```

### Tipos Inferidos
```java
// Tipos complexos
var mapa = new HashMap<String, Integer>();
var executor = Executors.newFixedThreadPool(10);
var padrao = Pattern.compile("\\w+");
```

## Restrições

### Onde Não Usar
```java
// Não permitido:
var campo; // Sem inicialização
var = "valor"; // Sem nome
var[] array = new int[10]; // Arrays
var método() { } // Retorno de método
```

### Limitações
```ascii
RESTRICTIONS
├── Variáveis de classe
├── Parâmetros de método
├── Retorno de método
└── Catch blocks
```

## Usos Comuns

### Loops
```java
// Iteração em collections
for (var item : lista) {
    System.out.println(item);
}

// Loop tradicional
for (var i = 0; i < 10; i++) {
    // código
}
```

### Lambda
```java
// Com var em parâmetros (Java 11+)
Consumer<String> consumer = (@NonNull var s) -> 
    System.out.println(s);
```

### Try-with-resources
```java
try (var arquivo = new FileInputStream
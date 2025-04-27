# Estruturas de Repetição

```ascii
>> Iniciando ciclos de execução...
>> Configurando iteradores...
>> Estabelecendo pontos de controle...
```

## Visão Geral

Loops são como rotinas de hack - eles permitem executar operações repetitivas de forma eficiente e controlada.

## Tipos de Loops

### 1. for Loop

```java
for (inicialização; condição; incremento) {
    // código a ser repetido
}
```

#### Exemplo Prático
```java
for (int i = 0; i < 5; i++) {
    System.out.println("Tentativa de acesso: " + i);
}
```

### 2. while Loop

```java
while (condição) {
    // código a ser repetido
}
```

#### Exemplo Prático
```java
int tentativas = 0;
while (tentativas < 3) {
    System.out.println("Tentando conexão...");
    tentativas++;
}
```

### 3. do-while Loop

```java
do {
    // código a ser repetido
} while (condição);
```

#### Exemplo Prático
```java
int senha;
do {
    senha = gerarSenha();
} while (!validarSenha(senha));
```

### 4. for-each Loop

```java
for (tipo elemento : coleção) {
    // código a ser repetido
}
```

#### Exemplo Prático
```java
String[] servidores = {"Alpha", "Beta", "Gamma"};
for (String servidor : servidores) {
    System.out.println("Verificando servidor: " + servidor);
}
```

## Controle de Loop

### break
Interrompe a execução do loop completamente.
```java
for (int i = 0; i < 100; i++) {
    if (detectarIntruso()) {
        break; // Sai do loop imediatamente
    }
}
```

### continue
Pula para a próxima iteração do loop.
```java
for (int porta = 0; porta < 1024; porta++) {
    if (!portaVulneravel(porta)) {
        continue; // Verifica próxima porta
    }
    atacarPorta(porta);
}
```

## Padrões de Uso

### 1. Loop Infinito Controlado
```java
while (true) {
    if (condicaoParada()) {
        break;
    }
    // processamento
}
```

### 2. Loop com Múltiplas Variáveis
```java
for (int i = 0, j = 10; i < j; i++, j--) {
    System.out.printf("i: %d, j: %d%n", i, j);
}
```

### 3. Loop Aninhado
```java
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        System.out.printf("[%d,%d] ", i, j);
    }
    System.out.println();
}
```

## Boas Práticas

1. **Use o Loop Adequado**
   ```java
   // Para número conhecido de iterações
   for (int i = 0; i < tamanho; i++) { }
   
   // Para condição desconhecida
   while (temDados()) { }
   
   // Para arrays/collections
   for (Elemento e : colecao) { }
   ```

2. **Evite Loop Infinito Acidental**
   ```java
   // Ruim - possível loop infinito
   while (x > 0) {
       // esqueceu de modificar x
   }
   
   // Bom
   while (x > 0) {
       x--;
       // processamento
   }
   ```

3. **Mantenha Loops Simples**
   ```java
   // Evite
   for (int i = 0; i < 100; i++) {
       // muito código aqui
   }
   
   // Prefira
   for (int i = 0; i < 100; i++) {
       processarItem(i);
   }
   ```

## Exemplos Avançados

### 1. Loop com Timer
```java
long inicio = System.currentTimeMillis();
long limite = 5000; // 5 segundos

while (System.currentTimeMillis() - inicio < limite) {
    // processamento limitado por tempo
}
```

### 2. Loop com Retry
```java
int maxTentativas = 3;
int tentativa = 0;

while (tentativa < maxTentativas) {
    try {
        conectar();
        break;
    } catch (Exception e) {
        tentativa++;
        if (tentativa == maxTentativas) {
            throw new RuntimeException("Falha na conexão");
        }
    }
}
```

### 3. Loop com Buffer
```java
StringBuilder buffer = new StringBuilder();
for (int i = 0; i < dados.length; i++) {
    buffer.append(dados[i]);
    if (buffer.length() >= 1000) {
        processarBuffer(buffer.toString());
        buffer.setLength(0);
    }
}
```

## Exercícios Práticos

1. **Scanner de Portas**
   ```java
   public void scanearPortas(int inicio, int fim) {
       for (int porta = inicio; porta <= fim; porta++) {
           if (portaAberta(porta)) {
               System.out.println("Porta " + porta + " está aberta");
           }
       }
   }
   ```

2. **Processador de Dados**
   ```java
   public void processarDados(List<String> dados) {
       int processados = 0;
       while (!dados.isEmpty()) {
           String dado = dados.remove(0);
           processar(dado);
           processados++;
           if (processados % 100 == 0) {
               System.out.println("Progresso: " + processados);
           }
       }
   }
   ```

## Próximos Passos

- Aprenda sobre condicionais em [Conditionals](conditionals.md)
- Explore expressões switch em [Switch Expressions](switch-expressions.md)
- Descubra pattern matching em [Pattern Matching](pattern-matching.md)

[Pattern Matching](pattern-matching.md){.next-step}
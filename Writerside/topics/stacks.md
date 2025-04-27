# Stacks: A Pilha de Downloads

```ascii
STACK OPERATIONS
├── push() (Upload)
├── pop()  (Download)
└── peek() (Preview)
```

## Fundamentos

Stacks são como uma pilha de downloads - o último arquivo baixado é o primeiro que você acessa (LIFO).

```java
// Criando uma pilha de downloads
Stack<String> downloads = new Stack<>();
downloads.push("arquivo.zip");    // Adiciona no topo
String ultimo = downloads.pop();  // Remove do topo
```

## Operações Básicas

### Push (Upload)
```java
Stack<String> stack = new Stack<>();
stack.push("Camada 1");  // Base
stack.push("Camada 2");  // Meio
stack.push("Camada 3");  // Topo
```

### Pop (Download)
```java
String top = stack.pop();     // Remove e retorna topo
String peek = stack.peek();   // Só espia o topo
boolean vazia = stack.empty(); // Checa se está vazia
```

### Busca
```java
int posicao = stack.search("Camada 1"); // Busca na pilha
// Retorna posição (1 = topo) ou -1 se não encontrar
```

## Casos de Uso

### 1. Histórico de Navegação
```java
Stack<String> historico = new Stack<>();
historico.push("homepage.html");
historico.push("perfil.html");
String voltar = historico.pop(); // Volta página
```

### 2. Desfazer/Refazer
```java
Stack<Command> undoStack = new Stack<>();
undoStack.push(new Command("save"));
Command lastCommand = undoStack.pop(); // Desfaz
```

### 3. Validação de Sintaxe
```java
Stack<Character> brackets = new Stack<>();
brackets.push('{');  // Abre
char close = brackets.pop(); // Fecha
// Válido se stack vazia no final
```

## Implementação Alternativa

```java
// Usando Deque como Stack (mais moderno)
Deque<String> stack = new ArrayDeque<>();
stack.push("Novo");
String top = stack.pop();
```

## Dicas de Performance

```java
// Vector é thread-safe mas mais lento
Stack<Integer> threadsafe = new Stack<>();

// ArrayDeque é mais rápido mas não thread-safe
Deque<Integer> fast = new ArrayDeque<>();
```

## Exercícios Práticos

1. Implemente um verificador de parênteses
2. Crie um sistema de desfazer/refazer
3. Desenvolva um navegador simplificado

## Próximos Passos

Depois de dominar Stacks, você estará pronto para:

1. Implementar históricos e navegação
2. Criar sistemas de desfazer/refazer
3. Validar expressões e sintaxe

[Queues: Filas](queues.md){.previous-step}
[Collections Projects](collections-projects.md){.next-step}

---

> "Stacks são como downloads: o último que chegou é o primeiro que você acessa!"
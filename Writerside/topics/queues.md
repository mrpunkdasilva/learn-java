# Queues: A Fila do Banco Digital

```ascii
QUEUE TYPES
├── Queue (Fila Normal)
├── Deque (Fila Premium)
└── PriorityQueue (Fila Preferencial)
```

## Fundamentos

Queues são como filas de banco digitais - primeiro a chegar, primeiro a ser atendido (FIFO).

```java
// Criando uma fila digital
Queue<String> fila = new LinkedList<>();
fila.offer("Cliente#1");    // Entra na fila
String proximo = fila.poll(); // Próximo a ser atendido
```

## Tipos de Queues

### Queue Básica
```java
Queue<String> atendimento = new LinkedList<>();
atendimento.offer("Usuário");  // Adiciona ao fim
atendimento.poll();            // Remove do início
atendimento.peek();            // Consulta próximo
```

### Deque (Double-Ended Queue)
```java
Deque<String> premium = new ArrayDeque<>();
premium.offerFirst("VIP");     // Fura fila
premium.offerLast("Regular");  // Entra normal
premium.pollFirst();           // Remove do início
premium.pollLast();           // Remove do fim
```

### PriorityQueue
```java
// Fila com prioridades
PriorityQueue<Integer> senha = new PriorityQueue<>();
senha.offer(3);  // Organiza automaticamente
senha.offer(1);  // por ordem natural
senha.offer(2);  // ou comparador customizado
```

## Operações Comuns

### Inserção
```java
Queue<String> fila = new LinkedList<>();
fila.offer("Normal");      // Preferido (retorna boolean)
fila.add("Força");        // Lança exceção se cheio
```

### Remoção
```java
String cliente = fila.poll();     // Retorna null se vazio
String proximo = fila.remove();   // Lança exceção se vazio
```

### Consulta
```java
String espiar = fila.peek();      // Retorna null se vazio
String primeiro = fila.element(); // Lança exceção se vazio
```

## Casos de Uso

1. **Processamento de Transações**
```java
Queue<Transaction> transactions = new LinkedList<>();
transactions.offer(new Transaction("Depósito"));
processTransaction(transactions.poll());
```

2. **Sistema de Mensagens**
```java
PriorityQueue<Message> messages = new PriorityQueue<>();
messages.offer(new Message("Urgente", 1));
messages.offer(new Message("Normal", 2));
```

## Dicas de Performance

```java
// Inicialize com tamanho se souber
Queue<String> fila = new LinkedList<>(100);

// Use o tipo certo para o caso
Deque<String> rapido = new ArrayDeque<>();  // Mais eficiente que LinkedList
```

## Exercícios Práticos

1. Implemente um sistema de atendimento
2. Crie um processador de eventos
3. Desenvolva um escalonador de tarefas

## Próximos Passos

Depois de dominar Queues, você estará pronto para:

1. Gerenciar filas de processamento
2. Implementar sistemas de mensageria
3. Criar escalonadores de tarefas

[Maps: Chave-Valor](maps.md){.previous-step}
[Stacks: Pilha](stacks.md){.next-step}

---

> "Queues são como filas digitais: justas, ordenadas e sempre processando na ordem certa!"
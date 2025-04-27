# Projetos Práticos: Collections em Ação

## Projeto 1: Task Manager (Lista de Contratos)

### Objetivo
Criar um sistema de gerenciamento de tarefas usando diferentes Collections.

```java
public class TaskManager {
    private List<Task> allTasks = new ArrayList<>();
    private Map<String, Task> taskById = new HashMap<>();
    private PriorityQueue<Task> urgentTasks = new PriorityQueue<>();
    
    public void addTask(Task task) {
        allTasks.add(task);
        taskById.put(task.getId(), task);
        if (task.isUrgent()) {
            urgentTasks.offer(task);
        }
    }
    
    public Task getNextUrgentTask() {
        return urgentTasks.poll();
    }
}
```

### Funcionalidades
- Adicionar/remover tarefas
- Priorização automática
- Busca por ID/status
- Histórico de alterações

## Projeto 2: Inventory System (Controle de Arsenal)

### Objetivo
Implementar um sistema de inventário com controle de estoque.

```java
public class InventorySystem {
    private Map<String, Item> inventory = new HashMap<>();
    private Set<String> lowStock = new HashSet<>();
    private Queue<Order> pendingOrders = new LinkedList<>();
    
    public void addItem(Item item) {
        inventory.put(item.getCode(), item);
        checkStock(item);
    }
    
    private void checkStock(Item item) {
        if (item.getQuantity() < item.getMinimum()) {
            lowStock.add(item.getCode());
            createRestockOrder(item);
        }
    }
}
```

### Funcionalidades
- Controle de estoque
- Alertas de baixo estoque
- Processamento de pedidos
- Relatórios de inventário

## Projeto 3: Cache Implementation (Memória Temporária)

### Objetivo
Desenvolver um sistema de cache com política de expiração.

```java
public class CacheSystem<K, V> {
    private Map<K, CacheEntry<V>> cache = new LinkedHashMap<>();
    private Queue<K> expirationQueue = new PriorityQueue<>();
    
    public void put(K key, V value, long ttl) {
        cache.put(key, new CacheEntry<>(value, ttl));
        expirationQueue.offer(key);
        cleanExpired();
    }
    
    public V get(K key) {
        CacheEntry<V> entry = cache.get(key);
        return (entry != null && !entry.isExpired()) ? entry.getValue() : null;
    }
}
```

### Funcionalidades
- Cache com TTL (Time To Live)
- Política LRU (Least Recently Used)
- Limpeza automática
- Estatísticas de hit/miss

## Desafios Extras

### 1. Sistema Multi-Thread
```java
public class ThreadSafeTaskManager {
    private final ConcurrentHashMap<String, Task> tasks = new ConcurrentHashMap<>();
    private final BlockingQueue<Task> taskQueue = new LinkedBlockingQueue<>();
    
    public void processTask() {
        while (true) {
            Task task = taskQueue.take(); // Bloqueia até ter tarefa
            executeTask(task);
        }
    }
}
```

### 2. Sistema de Eventos
```java
public class EventSystem {
    private final Deque<Event> eventHistory = new ArrayDeque<>();
    private final Map<String, List<EventHandler>> handlers = new HashMap<>();
    
    public void emit(Event event) {
        eventHistory.push(event);
        notifyHandlers(event);
    }
    
    public void undo() {
        if (!eventHistory.isEmpty()) {
            revertEvent(eventHistory.pop());
        }
    }
}
```

## Próximos Passos

1. Implemente os projetos base
2. Adicione funcionalidades extras
3. Otimize o código
4. Adicione testes unitários
5. Documente seu código

[Stacks: Pilhas](stacks.md){.previous-step}
[OOP Fundamentals](oop-fundamentals.md){.next-step}

---

> "A verdadeira maestria vem da prática. Cada projeto é uma chance de aperfeiçoar suas habilidades!"
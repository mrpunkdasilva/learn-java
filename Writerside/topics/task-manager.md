# Task Manager: Gerenciador de Tarefas Digital

## Objetivo do Projeto
Criar um gerenciador de tarefas simples usando arrays e collections básicas.

## Estruturas de Dados Utilizadas
```java
// Lista de tarefas usando array
String[] tarefas = new String[100];
int[] prioridades = new int[100];
boolean[] concluidas = new boolean[100];
int totalTarefas = 0;

// Lista dinâmica usando ArrayList
ArrayList<String> tarefasDinamicas = new ArrayList<>();

// Fila de tarefas urgentes
Queue<String> tarefasUrgentes = new LinkedList<>();

// Mapa para busca rápida
HashMap<String, Integer> indiceTarefas = new HashMap<>();
```

## Funcionalidades Principais

### 1. Adicionar Tarefa
```java
public static void adicionarTarefa(String tarefa, int prioridade) {
    if (totalTarefas < tarefas.length) {
        tarefas[totalTarefas] = tarefa;
        prioridades[totalTarefas] = prioridade;
        concluidas[totalTarefas] = false;
        
        // Adiciona nas estruturas dinâmicas
        tarefasDinamicas.add(tarefa);
        indiceTarefas.put(tarefa, totalTarefas);
        
        if (prioridade > 8) {
            tarefasUrgentes.offer(tarefa);
        }
        
        totalTarefas++;
        System.out.println("Tarefa adicionada: " + tarefa);
    }
}
```

### 2. Listar Tarefas
```java
public static void listarTarefas() {
    System.out.println("\n=== Lista de Tarefas ===");
    for (int i = 0; i < totalTarefas; i++) {
        String status = concluidas[i] ? "[X]" : "[ ]";
        System.out.printf("%s %s (Prioridade: %d)%n", 
            status, tarefas[i], prioridades[i]);
    }
}
```

### 3. Marcar Como Concluída
```java
public static void concluirTarefa(String tarefa) {
    Integer indice = indiceTarefas.get(tarefa);
    if (indice != null) {
        concluidas[indice] = true;
        System.out.println("Tarefa concluída: " + tarefa);
    }
}
```

### 4. Buscar Tarefas
```java
public static void buscarTarefa(String termo) {
    System.out.println("\n=== Resultados da Busca ===");
    for (int i = 0; i < totalTarefas; i++) {
        if (tarefas[i].toLowerCase().contains(termo.toLowerCase())) {
            System.out.println("- " + tarefas[i]);
        }
    }
}
```

### 5. Próxima Tarefa Urgente
```java
public static String proximaTarefaUrgente() {
    return tarefasUrgentes.poll();
}
```

## Exemplo de Uso
```java
public static void main(String[] args) {
    // Adicionar algumas tarefas
    adicionarTarefa("Debugar código", 9);
    adicionarTarefa("Backup sistema", 7);
    adicionarTarefa("Atualizar firewall", 10);
    
    // Listar todas as tarefas
    listarTarefas();
    
    // Concluir uma tarefa
    concluirTarefa("Backup sistema");
    
    // Buscar tarefas
    buscarTarefa("firewall");
    
    // Verificar próxima tarefa urgente
    String urgente = proximaTarefaUrgente();
    System.out.println("Próxima urgente: " + urgente);
}
```

## Desafios para Praticar

1. **Filtrar por Prioridade**
```java
public static void filtrarPorPrioridade(int minimo) {
    for (int i = 0; i < totalTarefas; i++) {
        if (prioridades[i] >= minimo) {
            System.out.println(tarefas[i]);
        }
    }
}
```

2. **Remover Tarefa**
```java
public static void removerTarefa(String tarefa) {
    Integer indice = indiceTarefas.get(tarefa);
    if (indice != null) {
        // Shift elements
        for (int i = indice; i < totalTarefas - 1; i++) {
            tarefas[i] = tarefas[i + 1];
            prioridades[i] = prioridades[i + 1];
            concluidas[i] = concluidas[i + 1];
        }
        totalTarefas--;
        
        // Atualizar estruturas dinâmicas
        tarefasDinamicas.remove(tarefa);
        indiceTarefas.remove(tarefa);
    }
}
```

## Exercícios Propostos

1. Implementar ordenação por prioridade
2. Adicionar data limite para tarefas
3. Criar filtro por status (pendente/concluída)
4. Implementar sistema de tags usando arrays
5. Adicionar persistência em arquivo texto

## Próximos Passos

- [Inventory System](inventory-system.md)
- [Cache Implementation](cache-implementation.md)

---

> "Uma tarefa bem organizada é uma tarefa meio feita!"
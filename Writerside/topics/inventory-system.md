# Sistema de Inventário (Arsenal)

Um sistema de inventário cyberpunk para gerenciar equipamentos e recursos.

## Objetivos de Aprendizado
- Implementar um sistema usando `Map`, `Set` e `Queue`
- Gerenciar estoque com estruturas de dados apropriadas
- Aplicar lógica de negócios com coleções

## Conceitos Aplicados
- HashMap para armazenamento principal
- HashSet para itens em baixo estoque
- Queue para pedidos pendentes
- Encapsulamento de dados
- Validações de negócio

## Implementação Base

### Classe Item

```java
public class Item {
    private String code;
    private String name;
    private int quantity;
    private int minimum;
    private double price;

    public Item(String code, String name, int quantity, int minimum, double price) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.minimum = minimum;
        this.price = price;
    }

    // Getters e Setters
    public String getCode() { return code; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public int getMinimum() { return minimum; }
    public double getPrice() { return price; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
}
```

### Classe Order

```java
public class Order {
    private String itemCode;
    private int quantity;
    private String status;

    public Order(String itemCode, int quantity) {
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.status = "PENDING";
    }

    // Getters e Setters
    public String getItemCode() { return itemCode; }
    public int getQuantity() { return quantity; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
```

### Sistema Principal

```java
public class InventorySystem {
    private Map<String, Item> inventory = new HashMap<>();
    private Set<String> lowStock = new HashSet<>();
    private Queue<Order> pendingOrders = new LinkedList<>();
    
    // Adicionar item ao inventário
    public void addItem(Item item) {
        inventory.put(item.getCode(), item);
        checkStock(item);
    }
    
    // Verificar nível de estoque
    private void checkStock(Item item) {
        if (item.getQuantity() < item.getMinimum()) {
            lowStock.add(item.getCode());
            createRestockOrder(item);
        }
    }
    
    // Criar pedido de reposição
    private void createRestockOrder(Item item) {
        int orderQuantity = item.getMinimum() - item.getQuantity();
        Order order = new Order(item.getCode(), orderQuantity);
        pendingOrders.offer(order);
    }
    
    // Remover item do inventário
    public void removeItem(String code) {
        inventory.remove(code);
        lowStock.remove(code);
    }
    
    // Atualizar quantidade
    public void updateQuantity(String code, int quantity) {
        Item item = inventory.get(code);
        if (item != null) {
            item.setQuantity(quantity);
            checkStock(item);
        }
    }
    
    // Listar itens em baixo estoque
    public Set<String> getLowStockItems() {
        return new HashSet<>(lowStock);
    }
    
    // Processar próximo pedido
    public Order processNextOrder() {
        return pendingOrders.poll();
    }
}
```

## Exemplo de Uso

```java
public class InventoryDemo {
    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();
        
        // Adicionar itens
        system.addItem(new Item("HACK001", "NetHack Module", 5, 10, 299.99));
        system.addItem(new Item("DECK002", "CyberDeck", 2, 5, 999.99));
        
        // Verificar baixo estoque
        Set<String> lowStock = system.getLowStockItems();
        System.out.println("Itens em baixo estoque: " + lowStock);
        
        // Processar pedidos
        Order nextOrder = system.processNextOrder();
        if (nextOrder != null) {
            System.out.println("Processando pedido: " + nextOrder.getItemCode());
        }
    }
}
```

## Exercícios Propostos

1. **Implementar Relatórios**
   - Gerar relatório de valor total do inventário
   - Listar itens por faixa de preço
   - Calcular estatísticas de pedidos

2. **Adicionar Validações**
   - Verificar códigos duplicados
   - Validar quantidades negativas
   - Implementar limites de estoque

3. **Expandir Funcionalidades**
   - Adicionar categorias de itens
   - Implementar sistema de alertas
   - Criar histórico de transações

## Desafios Avançados

1. **Sistema de Prioridade**
   - Implementar PriorityQueue para pedidos
   - Definir critérios de priorização
   - Gerenciar pedidos urgentes

2. **Persistência de Dados**
   - Salvar estado do inventário
   - Carregar dados de arquivo
   - Implementar backup automático

## Dicas de Implementação

- Use enums para status e categorias
- Implemente tratamento de exceções
- Mantenha o código modular
- Documente as funcionalidades
- Adicione logs de operações

## Próximos Passos

- [Cache Implementation](cache-implementation.md)
- [Collections Overview](collections-overview.md)
- [Maps](maps.md)

---

> "Um bom arsenal não é apenas sobre quantidade, mas sobre organização e controle."
public class InventorySystem {
    // Arrays para armazenar dados do inventário
    private String[] itemNames;
    private int[] quantities;
    private double[] prices;
    private int itemCount;
    private final int MAX_ITEMS = 100;

    public InventorySystem() {
        itemNames = new String[MAX_ITEMS];
        quantities = new int[MAX_ITEMS];
        prices = new double[MAX_ITEMS];
        itemCount = 0;
    }

    // Adicionar novo item
    public void addItem(String name, int quantity, double price) {
        if (itemCount < MAX_ITEMS) {
            itemNames[itemCount] = name;
            quantities[itemCount] = quantity;
            prices[itemCount] = price;
            itemCount++;
            System.out.println("Item adicionado com sucesso!");
        } else {
            System.out.println("Inventário cheio!");
        }
    }

    // Mostrar todos os itens
    public void showItems() {
        System.out.println("\n=== Inventário ===");
        System.out.println("Nome | Quantidade | Preço");
        System.out.println("------------------------");
        
        for (int i = 0; i < itemCount; i++) {
            String formattedPrice = String.format("R$%.2f", prices[i]);
            System.out.println(itemNames[i] + " | " + 
                             quantities[i] + " | " + 
                             formattedPrice);
        }
    }

    // Buscar item por nome
    public void searchItem(String name) {
        boolean found = false;
        
        for (int i = 0; i < itemCount; i++) {
            if (itemNames[i].equals(name)) {
                System.out.println("\nItem encontrado:");
                System.out.println("Nome: " + itemNames[i]);
                System.out.println("Quantidade: " + quantities[i]);
                System.out.println("Preço: R$" + String.format("%.2f", prices[i]));
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Item não encontrado!");
        }
    }

    // Atualizar quantidade
    public void updateQuantity(String name, int newQuantity) {
        for (int i = 0; i < itemCount; i++) {
            if (itemNames[i].equals(name)) {
                quantities[i] = newQuantity;
                System.out.println("Quantidade atualizada!");
                return;
            }
        }
        System.out.println("Item não encontrado!");
    }

    // Calcular valor total do inventário
    public void calculateTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += quantities[i] * prices[i];
        }
        System.out.println("\nValor total do inventário: R$" + 
                          String.format("%.2f", total));
    }
}
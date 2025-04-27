import java.util.Scanner;

public class InventoryDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventorySystem inventory = new InventorySystem();
        
        while (true) {
            System.out.println("\n=== Sistema de Inventário ===");
            System.out.println("1. Adicionar item");
            System.out.println("2. Mostrar todos os itens");
            System.out.println("3. Buscar item");
            System.out.println("4. Atualizar quantidade");
            System.out.println("5. Calcular valor total");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            switch (choice) {
                case 1:
                    System.out.print("Nome do item: ");
                    String name = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Preço: R$");
                    double price = scanner.nextDouble();
                    inventory.addItem(name, quantity, price);
                    break;
                    
                case 2:
                    inventory.showItems();
                    break;
                    
                case 3:
                    System.out.print("Nome do item para buscar: ");
                    String searchName = scanner.nextLine();
                    inventory.searchItem(searchName);
                    break;
                    
                case 4:
                    System.out.print("Nome do item: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Nova quantidade: ");
                    int newQuantity = scanner.nextInt();
                    inventory.updateQuantity(updateName, newQuantity);
                    break;
                    
                case 5:
                    inventory.calculateTotal();
                    break;
                    
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
import java.util.Scanner;

public class CacheDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o tamanho máximo do cache: ");
        int maxSize = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        SimpleCache cache = new SimpleCache(maxSize);
        
        while (true) {
            System.out.println("\n=== Sistema de Cache ===");
            System.out.println("1. Adicionar/Atualizar item");
            System.out.println("2. Buscar item");
            System.out.println("3. Mostrar estatísticas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            switch (choice) {
                case 1:
                    System.out.print("Digite a chave: ");
                    String key = scanner.nextLine();
                    System.out.print("Digite o valor: ");
                    String value = scanner.nextLine();
                    cache.put(key, value);
                    System.out.println("Item adicionado/atualizado!");
                    break;
                    
                case 2:
                    System.out.print("Digite a chave para buscar: ");
                    String searchKey = scanner.nextLine();
                    String result = cache.get(searchKey);
                    if (result != null) {
                        System.out.println("Valor encontrado: " + result);
                    } else {
                        System.out.println("Chave não encontrada!");
                    }
                    break;
                    
                case 3:
                    cache.showStats();
                    break;
                    
                case 4:
                    System.out.println("Encerrando...");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
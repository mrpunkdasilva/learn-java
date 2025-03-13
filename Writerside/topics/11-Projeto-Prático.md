# Projeto Prático

## **Projeto Refatorado: Sistema de Gerenciamento de Inventário com SQLite**

### **Estrutura do Projeto**
1. **`Database.java`:** Gerencia a conexão com o banco de dados.
2. **`Item.java`:** Representa um item no inventário.
3. **`Inventario.java`:** Gerencia a lógica do inventário e interage com o banco de dados.
4. **`Main.java`:** Interface simples para interagir com o inventário.

---

#### **1. Classe `Database`**

Responsável por gerenciar a conexão com o banco de dados e criar a tabela se necessário.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String URL = "jdbc:sqlite:inventario.db";

    // Retorna uma conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Cria a tabela de itens se não existir
    public static void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS itens (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "nome TEXT NOT NULL," +
                     "quantidade INTEGER NOT NULL)";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
}
```

---

#### **2. Classe `Item`**

Representa um item no inventário.

```java
public class Item {
    private int id;
    private String nome;
    private int quantidade;

    public Item(int id, String nome, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return nome + " (Quantidade: " + quantidade + ")";
    }
}
```

---

#### **3. Classe `Inventario`**

Gerencia a lógica do inventário e interage com o banco de dados.

```java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Item> itens;

    public Inventario() {
        itens = new ArrayList<>();
        carregarItens();
    }

    // Carrega os itens do banco de dados
    private void carregarItens() {
        String sql = "SELECT * FROM itens";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int quantidade = rs.getInt("quantidade");
                itens.add(new Item(id, nome, quantidade));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao carregar itens: " + e.getMessage());
        }
    }

    // Adiciona um item ao inventário e ao banco de dados
    public void adicionarItem(String nome, int quantidade) {
        String sql = "INSERT INTO itens (nome, quantidade) VALUES (?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, nome);
            stmt.setInt(2, quantidade);
            stmt.executeUpdate();

            // Recupera o ID gerado
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                itens.add(new Item(id, nome, quantidade));
                System.out.println(quantidade + " " + nome + "(s) adicionado(s).");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar item: " + e.getMessage());
        }
    }

    // Remove um item do inventário e do banco de dados
    public void removerItem(String nome, int quantidade) {
        for (Item item : itens) {
            if (item.getNome().equals(nome)) {
                if (item.getQuantidade() >= quantidade) {
                    item.setQuantidade(item.getQuantidade() - quantidade);
                    atualizarItemNoBanco(item);
                    System.out.println(quantidade + " " + nome + "(s) removido(s). Restante: " + item.getQuantidade());
                    if (item.getQuantidade() == 0) {
                        itens.remove(item);
                        deletarItemDoBanco(item);
                    }
                } else {
                    System.out.println("Quantidade insuficiente de " + nome + " no inventário.");
                }
                return;
            }
        }
        System.out.println("Item " + nome + " não encontrado no inventário.");
    }

    // Atualiza a quantidade de um item no banco de dados
    private void atualizarItemNoBanco(Item item) {
        String sql = "UPDATE itens SET quantidade = ? WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, item.getQuantidade());
            stmt.setInt(2, item.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar item: " + e.getMessage());
        }
    }

    // Remove um item do banco de dados
    private void deletarItemDoBanco(Item item) {
        String sql = "DELETE FROM itens WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, item.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao deletar item: " + e.getMessage());
        }
    }

    // Lista todos os itens do inventário
    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("O inventário está vazio.");
        } else {
            System.out.println("Itens no inventário:");
            for (Item item : itens) {
                System.out.println(item);
            }
        }
    }

    // Verifica a quantidade de um item específico
    public void verificarQuantidade(String nome) {
        for (Item item : itens) {
            if (item.getNome().equals(nome)) {
                System.out.println("Quantidade de " + nome + ": " + item.getQuantidade());
                return;
            }
        }
        System.out.println("Item " + nome + " não encontrado no inventário.");
    }
}
```

---

#### **4. Classe `Main`**

Interface simples para interagir com o inventário.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database.criarTabela(); // Garante que a tabela exista
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sistema de Gerenciamento de Inventário ---");
            System.out.println("1. Adicionar item");
            System.out.println("2. Remover item");
            System.out.println("3. Listar itens");
            System.out.println("4. Verificar quantidade de um item");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do item: ");
                    String nomeAdicionar = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidadeAdicionar = scanner.nextInt();
                    inventario.adicionarItem(nomeAdicionar, quantidadeAdicionar);
                    break;
                case 2:
                    System.out.print("Nome do item: ");
                    String nomeRemover = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidadeRemover = scanner.nextInt();
                    inventario.removerItem(nomeRemover, quantidadeRemover);
                    break;
                case 3:
                    inventario.listarItens();
                    break;
                case 4:
                    System.out.print("Nome do item: ");
                    String nomeVerificar = scanner.nextLine();
                    inventario.verificarQuantidade(nomeVerificar);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
```

---

## **Como Executar**

1. Baixe o driver SQLite JDBC e adicione ao seu projeto.
2. Crie o banco de dados `inventario.db` e a tabela `itens` (o código já faz isso automaticamente).
3. Execute a classe `Main`.

---

## **Próximos Passos**
Agora que o projeto está mais limpo e organizado, você pode adicionar novas funcionalidades, como:
- Validação de entradas do usuário.
- Interface gráfica usando JavaFX ou Swing.
- Exportação/importação de dados para outros formatos (JSON, CSV).

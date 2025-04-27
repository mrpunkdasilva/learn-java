import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TaskManager {
    // Arrays para armazenar dados das tarefas
    static String[] tarefas = new String[100];
    static int[] prioridades = new int[100];
    static boolean[] concluidas = new boolean[100];
    static int totalTarefas = 0;

    // Estruturas dinâmicas
    static ArrayList<String> tarefasDinamicas = new ArrayList<>();
    static Queue<String> tarefasUrgentes = new LinkedList<>();
    static HashMap<String, Integer> indiceTarefas = new HashMap<>();

    // Método principal com menu interativo
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.println("\nDigite a descrição da tarefa:");
                    String tarefa = scanner.nextLine();
                    System.out.println("Digite a prioridade (1-10):");
                    int prioridade = scanner.nextInt();
                    adicionarTarefa(tarefa, prioridade);
                    break;

                case 2:
                    listarTarefas();
                    break;

                case 3:
                    System.out.println("\nDigite a tarefa a ser concluída:");
                    String tarefaConcluir = scanner.nextLine();
                    concluirTarefa(tarefaConcluir);
                    break;

                case 4:
                    System.out.println("\nDigite o termo de busca:");
                    String termo = scanner.nextLine();
                    buscarTarefa(termo);
                    break;

                case 5:
                    String urgente = proximaTarefaUrgente();
                    if (urgente != null) {
                        System.out.println("\nPróxima tarefa urgente: " + urgente);
                    } else {
                        System.out.println("\nNão há tarefas urgentes pendentes.");
                    }
                    break;

                case 6:
                    System.out.println("\nDigite a tarefa a ser removida:");
                    String tarefaRemover = scanner.nextLine();
                    removerTarefa(tarefaRemover);
                    break;

                case 7:
                    System.out.println("\nDigite a prioridade mínima:");
                    int minimo = scanner.nextInt();
                    filtrarPorPrioridade(minimo);
                    break;

                case 0:
                    System.out.println("\nEncerrando o programa...");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    // Exibe o menu de opções
    static void exibirMenu() {
        System.out.println("\n=== GERENCIADOR DE TAREFAS ===");
        System.out.println("1. Adicionar tarefa");
        System.out.println("2. Listar tarefas");
        System.out.println("3. Concluir tarefa");
        System.out.println("4. Buscar tarefas");
        System.out.println("5. Próxima tarefa urgente");
        System.out.println("6. Remover tarefa");
        System.out.println("7. Filtrar por prioridade");
        System.out.println("0. Sair");
        System.out.println("Escolha uma opção:");
    }

    // Adiciona uma nova tarefa
    static void adicionarTarefa(String tarefa, int prioridade) {
        if (totalTarefas < tarefas.length) {
            tarefas[totalTarefas] = tarefa;
            prioridades[totalTarefas] = prioridade;
            concluidas[totalTarefas] = false;
            
            tarefasDinamicas.add(tarefa);
            indiceTarefas.put(tarefa, totalTarefas);
            
            if (prioridade > 8) {
                tarefasUrgentes.offer(tarefa);
            }
            
            totalTarefas++;
            System.out.println("Tarefa adicionada com sucesso!");
        } else {
            System.out.println("Limite de tarefas atingido!");
        }
    }

    // Lista todas as tarefas
    static void listarTarefas() {
        if (totalTarefas == 0) {
            System.out.println("\nNenhuma tarefa cadastrada!");
            return;
        }

        System.out.println("\n=== LISTA DE TAREFAS ===");
        for (int i = 0; i < totalTarefas; i++) {
            String status = concluidas[i] ? "[X]" : "[ ]";
            System.out.printf("%d. %s %s (Prioridade: %d)%n", 
                i + 1, status, tarefas[i], prioridades[i]);
        }
    }

    // Marca uma tarefa como concluída
    static void concluirTarefa(String tarefa) {
        Integer indice = indiceTarefas.get(tarefa);
        if (indice != null) {
            concluidas[indice] = true;
            System.out.println("Tarefa marcada como concluída!");
        } else {
            System.out.println("Tarefa não encontrada!");
        }
    }

    // Busca tarefas por termo
    static void buscarTarefa(String termo) {
        boolean encontrou = false;
        System.out.println("\n=== RESULTADOS DA BUSCA ===");
        
        for (int i = 0; i < totalTarefas; i++) {
            if (tarefas[i].toLowerCase().contains(termo.toLowerCase())) {
                String status = concluidas[i] ? "[X]" : "[ ]";
                System.out.printf("%s %s (Prioridade: %d)%n", 
                    status, tarefas[i], prioridades[i]);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma tarefa encontrada!");
        }
    }

    // Retorna a próxima tarefa urgente
    static String proximaTarefaUrgente() {
        return tarefasUrgentes.poll();
    }

    // Remove uma tarefa
    static void removerTarefa(String tarefa) {
        Integer indice = indiceTarefas.get(tarefa);
        if (indice != null) {
            // Deslocar elementos
            for (int i = indice; i < totalTarefas - 1; i++) {
                tarefas[i] = tarefas[i + 1];
                prioridades[i] = prioridades[i + 1];
                concluidas[i] = concluidas[i + 1];
            }
            totalTarefas--;
            
            // Atualizar estruturas dinâmicas
            tarefasDinamicas.remove(tarefa);
            indiceTarefas.remove(tarefa);
            tarefasUrgentes.remove(tarefa);
            
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Tarefa não encontrada!");
        }
    }

    // Filtra tarefas por prioridade mínima
    static void filtrarPorPrioridade(int minimo) {
        boolean encontrou = false;
        System.out.println("\n=== TAREFAS COM PRIORIDADE >=" + minimo + " ===");
        
        for (int i = 0; i < totalTarefas; i++) {
            if (prioridades[i] >= minimo) {
                String status = concluidas[i] ? "[X]" : "[ ]";
                System.out.printf("%s %s (Prioridade: %d)%n", 
                    status, tarefas[i], prioridades[i]);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma tarefa encontrada com essa prioridade!");
        }
    }
}
# Sistema de Menu

## Descrição do Projeto
Desenvolva um sistema de menu interativo estilo cyberpunk para uma interface de terminal.

## Conceitos Aplicados
- Switch Expressions
- Pattern Matching
- Loops
- Condicionais Aninhados

## Implementação Base

```java
public class MenuSystem {
    public static void main(String[] args) {
        // Estado atual do menu usando String
        String menuAtual = "PRINCIPAL";
        
        // Flag para controle do loop
        boolean sistemaAtivo = true;
        
        // Mensagem de boas-vindas usando Text Block
        System.out.println("""
            === SISTEMA CYBERDECK v1.0 ===
            Menu Principal:
            1. Iniciar Sistema
            2. Configurações
            3. Status
            4. Sair
            ===========================
            """);
        
        // Loop principal do sistema
        while (sistemaAtivo) {
            System.out.println("\nMenu atual: " + menuAtual);
            System.out.print("Digite uma opção: ");
            
            // Simulando entrada do usuário (você pode modificar para testar)
            var opcao = "1"; // Simula entrada do usuário
            
            // Controle de fluxo baseado no menu atual
            switch (menuAtual) {
                case "PRINCIPAL":
                    switch (opcao) {
                        case "1":
                            menuAtual = "SISTEMA";
                            System.out.println("""
                                === Menu do Sistema ===
                                1. Verificar Status
                                2. Executar Diagnóstico
                                3. Voltar
                                """);
                            break;
                        case "2":
                            menuAtual = "CONFIG";
                            System.out.println("""
                                === Menu de Configurações ===
                                1. Display
                                2. Segurança
                                3. Rede
                                4. Voltar
                                """);
                            break;
                        case "3":
                            System.out.println("""
                                Status do Sistema:
                                - Memória: OK
                                - Processador: OK
                                - Rede: OK
                                """);
                            break;
                        case "4":
                            sistemaAtivo = false;
                            break;
                    }
                    break;
                    
                case "CONFIG":
                    switch (opcao) {
                        case "1":
                            System.out.println("Configurando Display...");
                            break;
                        case "2":
                            System.out.println("Configurando Segurança...");
                            break;
                        case "3":
                            System.out.println("Configurando Rede...");
                            break;
                        case "4":
                            menuAtual = "PRINCIPAL";
                            System.out.println("Voltando ao Menu Principal...");
                            break;
                    }
                    break;
                    
                case "SISTEMA":
                    switch (opcao) {
                        case "1":
                            System.out.println("Verificando status...");
                            break;
                        case "2":
                            System.out.println("Executando diagnóstico...");
                            break;
                        case "3":
                            menuAtual = "PRINCIPAL";
                            System.out.println("Voltando ao Menu Principal...");
                            break;
                    }
                    break;
            }
            
            // Pequena pausa para simular processamento
            System.out.println("Processando...");
        }
        
        System.out.println("Sistema finalizado.");
    }
}
```

## Interface com Usuário

```java
public class MenuSystemUI {
    public static void main(String[] args) {
        MenuSystem menu = new MenuSystem();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("""
            === SISTEMA CYBERDECK v1.0 ===
            Iniciando interface...
            """);
        
        String input;
        do {
            System.out.print("> ");
            input = scanner.nextLine().trim();
            String response = menu.processInput(input);
            System.out.println(response);
        } while (!input.equals("exit"));
    }
}
```

## Recursos Avançados

1. **Animações de Terminal**
```java
public class TerminalEffects {
    public static void typeWriter(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
}
```

2. **Sistema de Cores**
```java
public class ColoredOutput {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public static String success(String text) {
        return ANSI_GREEN + text + ANSI_RESET;
    }
    
    public static String error(String text) {
        return ANSI_RED + text + ANSI_RESET;
    }
}
```

## Desafios de Extensão

1. Adicione autenticação de usuário
2. Implemente submenus dinâmicos
3. Crie um sistema de logs
4. Adicione efeitos visuais ASCII art

## Próximos Passos
- Implemente mais funcionalidades no menu
- Adicione persistência de configurações
- Crie uma interface gráfica ASCII mais elaborada

[State Machine](state-machine.md){.next-step}
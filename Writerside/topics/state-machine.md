# Máquina de Estados

## Descrição do Projeto
Implemente uma máquina de estados que simula um sistema de segurança cyberpunk.

## Conceitos Aplicados
- Pattern Matching
- Switch Expressions
- Loops Controlados por Estado
- Condicionais Complexos

## Implementação Base

```java
public class StateMachine {
    public static void main(String[] args) {
        // Estados possíveis usando String
        String estado = "TRAVADO";  // estado inicial
        
        // Contadores e flags usando tipos primitivos
        int tentativasInvalidas = 0;
        boolean sistemaAtivo = true;
        
        // Mensagem de boas-vindas usando Text Block
        System.out.println("""
            === SISTEMA DE SEGURANÇA CYBERPUNK ===
            Estados: TRAVADO, DESTRAVADO, ALERTA
            Comandos: 
            1 - Inserir código válido
            2 - Inserir código inválido
            3 - Travar sistema
            4 - Sair
            ====================================
            """);
        
        // Loop principal do sistema
        while (sistemaAtivo) {
            System.out.println("\nEstado atual: " + estado);
            System.out.print("Digite um comando: ");
            
            // Simulando entrada do usuário (você pode modificar os valores para testar)
            var comando = "1"; // Simula entrada do usuário
            
            // Controle de fluxo baseado no estado atual
            switch (estado) {
                case "TRAVADO":
                    if (comando.equals("1")) {
                        estado = "DESTRAVADO";
                        tentativasInvalidas = 0;
                        System.out.println("Acesso concedido!");
                    } else if (comando.equals("2")) {
                        tentativasInvalidas++;
                        if (tentativasInvalidas >= 3) {
                            estado = "ALERTA";
                            System.out.println("ALERTA: Múltiplas tentativas inválidas!");
                        } else {
                            System.out.println("Código inválido. Tentativas restantes: " + (3 - tentativasInvalidas));
                        }
                    }
                    break;
                    
                case "DESTRAVADO":
                    if (comando.equals("3")) {
                        estado = "TRAVADO";
                        System.out.println("Sistema travado!");
                    }
                    break;
                    
                case "ALERTA":
                    if (comando.equals("1")) {
                        estado = "TRAVADO";
                        tentativasInvalidas = 0;
                        System.out.println("Sistema resetado!");
                    }
                    break;
            }
            
            // Condição de saída
            if (comando.equals("4")) {
                sistemaAtivo = false;
                System.out.println("Encerrando sistema...");
            }
            
            // Pequena pausa para simular processamento
            System.out.println("Processando...");
        }
    }
}
```

## Interface com Usuário

```java
public class SecuritySystemUI {
    public static void main(String[] args) {
        SecuritySystem system = new SecuritySystem();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("""
            === SISTEMA DE SEGURANÇA CYBERPUNK ===
            Digite 'help' para ver os comandos disponíveis
            """);
        
        while (true) {
            System.out.print(">> ");
            String input = scanner.nextLine().toUpperCase();
            
            if (input.equals("EXIT")) break;
            
            try {
                SecurityEvent event = SecurityEvent.valueOf(input);
                String result = system.processEvent(event);
                System.out.println(result);
            } catch (IllegalArgumentException e) {
                if (input.equals("HELP")) {
                    showHelp();
                } else {
                    System.out.println("Comando inválido");
                }
            }
        }
    }
    
    private static void showHelp() {
        System.out.println("""
            Comandos disponíveis:
            VALID_CODE - Tentar código de acesso
            INVALID_CODE - Código inválido
            LOCK - Travar sistema
            EMERGENCY - Ativar emergência
            MAINTENANCE_KEY - Modo manutenção
            RESET - Resetar sistema
            SHUTDOWN - Desligar sistema
            EXIT - Sair do programa
            """);
    }
}
```

## Recursos Avançados

1. **Sistema de Biometria**
```java
public class BiometricScanner {
    public boolean validateBiometric(String bioData) {
        return switch (bioData.length()) {
            case 32 -> bioData.matches("[A-F0-9]+");
            case 64 -> bioData.matches("[a-f0-9]+");
            default -> false;
        };
    }
}
```

2. **Monitor de Atividades**
```java
public class ActivityMonitor {
    private final Queue<SecurityEvent> recentEvents;
    private static final int MAX_EVENTS = 10;
    
    public ActivityMonitor() {
        this.recentEvents = new LinkedList<>();
    }
    
    public void recordEvent(SecurityEvent event) {
        recentEvents.offer(event);
        if (recentEvents.size() > MAX_EVENTS) {
            recentEvents.poll();
        }
    }
    
    public boolean detectSuspiciousActivity() {
        long invalidAttempts = recentEvents.stream()
            .filter(e -> e == SecurityEvent.INVALID_CODE)
            .count();
        return invalidAttempts >= 3;
    }
}
```

## Desafios de Extensão

1. Implemente um sistema de níveis de acesso
2. Adicione criptografia para códigos de acesso
3. Crie um sistema de backup automático
4. Implemente notificações em tempo real

## Próximos Passos
- Adicione mais estados e eventos
- Implemente persistência de logs
- Crie uma interface gráfica mais elaborada
- Adicione suporte a múltiplos usuários

[Control Flow](control-flow.md){.next-step}
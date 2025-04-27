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
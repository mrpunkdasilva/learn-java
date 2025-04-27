public class NumberGame {
    public static void main(String[] args) {
        // Configurações do jogo usando tipos primitivos
        int numeroSecreto = 42; // Número fixo para simplificar
        int tentativasMaximas = 5;
        int tentativas = 0;
        boolean jogoAtivo = true;
        
        // Mensagem inicial usando Text Block
        System.out.println("""
            === JOGO DE ADIVINHAÇÃO ===
            Tente adivinhar o número entre 1 e 100
            Você tem 5 tentativas!
            =========================
            """);
        
        // Loop principal do jogo
        while (jogoAtivo && tentativas < tentativasMaximas) {
            System.out.println("\nTentativa " + (tentativas + 1) + " de " + tentativasMaximas);
            System.out.print("Digite seu palpite: ");
            
            // Simulando entrada do usuário (você pode modificar para testar)
            var palpite = 50; // Simula entrada do usuário
            
            // Incrementa tentativas
            tentativas++;
            
            // Verifica o palpite
            if (palpite == numeroSecreto) {
                System.out.println("Parabéns! Você acertou em " + tentativas + " tentativas!");
                jogoAtivo = false;
            } else {
                // Verifica se ainda tem tentativas
                if (tentativas >= tentativasMaximas) {
                    System.out.println("Game Over! O número era " + numeroSecreto);
                } else {
                    // Dá dicas baseadas no palpite
                    if (palpite < numeroSecreto) {
                        System.out.println("Tente um número MAIOR!");
                    } else {
                        System.out.println("Tente um número MENOR!");
                    }
                    
                    // Mostra tentativas restantes
                    System.out.println("Tentativas restantes: " + (tentativasMaximas - tentativas));
                }
            }
            
            // Pequena pausa para simular processamento
            System.out.println("Processando...");
        }
        
        // Pontuação final
        int pontuacao = 0;
        if (!jogoAtivo) { // Se acertou
            pontuacao = (tentativasMaximas - tentativas + 1) * 100;
            System.out.println("Sua pontuação: " + pontuacao);
        }
        
        System.out.println("Fim do jogo!");
    }
}
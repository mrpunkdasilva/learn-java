# Jogo de Números

## Descrição do Projeto
Desenvolva um jogo de adivinhação onde o jogador tenta adivinhar um número gerado aleatoriamente pelo sistema.

## Conceitos Aplicados
- Loops (while/do-while)
- Condicionais (if/else)
- Switch Expressions
- Pattern Matching

## Implementação Base

```java
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
```

## Interface com Usuário

```java
public class NumberGameUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberGame game = new NumberGame(100, 5);
        
        System.out.println("=== Jogo de Adivinhação ===");
        System.out.println("Tente adivinhar o número entre 1 e 100");
        
        do {
            System.out.print("Digite seu palpite: ");
            if (scanner.hasNextInt()) {
                int guess = scanner.nextInt();
                String result = game.processGuess(guess);
                System.out.println(result);
            } else {
                System.out.println("Por favor, digite um número válido!");
                scanner.next();
            }
        } while (!game.isGameOver());
    }
}
```

## Desafios de Extensão

1. **Níveis de Dificuldade**
```java
public enum Difficulty {
    EASY(1, 10, 6),
    MEDIUM(1, 100, 5),
    HARD(1, 1000, 4);

    final int min, max, attempts;
    
    Difficulty(int min, int max, int attempts) {
        this.min = min;
        this.max = max;
        this.attempts = attempts;
    }
}
```

2. **Sistema de Pontuação**
```java
public int calculateScore() {
    return switch (state) {
        case WON -> (maxAttempts - attempts + 1) * 100;
        case LOST -> 0;
        default -> throw new IllegalStateException("Jogo ainda em andamento");
    };
}
```

## Próximos Passos
- Implemente o sistema de dificuldade
- Adicione um sistema de recordes
- Crie um modo multiplayer

[Menu System](menu-system.md){.next-step}
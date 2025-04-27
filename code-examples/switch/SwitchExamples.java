public class SwitchExamples {
    public void demonstrateTraditionalSwitch(String day) {
        // Traditional switch
        switch (day) {
            case "Segunda":
                System.out.println("Início da semana");
                break;
            case "Quarta":
                System.out.println("Meio da semana");
                break;
            case "Sexta":
                System.out.println("Fim da semana");
                break;
            default:
                System.out.println("Outro dia");
        }
    }

    public void demonstrateSwitchExpression(String status) {
        // Switch expression
        String message = switch (status) {
            case "ATIVO" -> "Usuário está ativo";
            case "INATIVO" -> "Usuário está inativo";
            case "PENDENTE" -> "Aguardando ativação";
            default -> "Status desconhecido";
        };

        // Switch expression with yield
        int priority = switch (status) {
            case "ATIVO" -> {
                System.out.println("Processando status ativo");
                yield 1;
            }
            case "INATIVO" -> {
                System.out.println("Processando status inativo");
                yield 0;
            }
            default -> -1;
        };
    }

    public void demonstrateMultipleLabels(int day) {
        // Multiple case labels
        String type = switch (day) {
            case 1, 2, 3, 4, 5 -> "Dia útil";
            case 6, 7 -> "Fim de semana";
            default -> "Dia inválido";
        };
    }
}
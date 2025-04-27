package com.netrunner.strings;

public class StringBasicsExample {
    public static void main(String[] args) {
        System.out.println("String Pool e Imutabilidade:");
        System.out.println("==========================");
        
        // Criação de Strings
        String codeName = "NETRUNNER";  // String Pool
        String agentId = new String("NETRUNNER");  // Heap
        
        // Comparação de referências
        System.out.println("codeName == agentId: " + (codeName == agentId));  // false
        System.out.println("codeName.equals(agentId): " + codeName.equals(agentId));  // true
        
        // Demonstração de imutabilidade
        String status = "ONLINE";
        System.out.println("\nAntes da concatenação: " + status);
        status.concat("_ACTIVE");  // Não modifica a string original
        System.out.println("Depois da concatenação (sem atribuição): " + status);
        status = status.concat("_ACTIVE");  // Cria nova string
        System.out.println("Depois da concatenação (com atribuição): " + status);

        // Operações básicas
        System.out.println("\nOperações Básicas:");
        System.out.println("=================");
        
        String hackCode = "CYBER_MATRIX_2077";
        
        // Comprimento
        System.out.println("Comprimento: " + hackCode.length());
        
        // Caractere específico
        System.out.println("Caractere na posição 6: " + hackCode.charAt(6));
        
        // Substring
        System.out.println("Substring (6, 12): " + hackCode.substring(6, 12));
        
        // Concatenação com '+'
        String prefix = "AGENT";
        String suffix = "ACTIVE";
        String fullId = prefix + "_" + suffix;
        System.out.println("Concatenação: " + fullId);

        // Exemplos de uso prático
        System.out.println("\nExemplos Práticos:");
        System.out.println("================");
        
        String dataPacket = "STATUS:CONNECTED:PORT:8080";
        String[] parts = dataPacket.split(":");
        
        System.out.println("Parsing de pacote de dados:");
        for (int i = 0; i < parts.length; i += 2) {
            if (i + 1 < parts.length) {
                System.out.println(parts[i] + " = " + parts[i + 1]);
            }
        }

        // Validação de dados
        String securityCode = "   NET-SEC-001   ";
        System.out.println("\nCódigo original: '" + securityCode + "'");
        System.out.println("Código limpo: '" + securityCode.trim() + "'");
        
        // Case sensitivity em verificações de segurança
        String expectedCode = "NET-SEC-001";
        System.out.println("Código válido (case sensitive): " + 
                          securityCode.trim().equals(expectedCode));
        System.out.println("Código válido (case insensitive): " + 
                          securityCode.trim().equalsIgnoreCase(expectedCode));
    }
}
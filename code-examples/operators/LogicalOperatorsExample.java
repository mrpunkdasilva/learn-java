package com.netrunner.operators;

public class LogicalOperatorsExample {
    public static void main(String[] args) {
        // Operadores lógicos básicos
        System.out.println("Operadores Lógicos Básicos:");
        System.out.println("=========================");
        
        boolean systemActive = true;
        boolean securityBreach = false;
        
        // AND lógico (&&)
        boolean systemSecure = systemActive && !securityBreach;
        System.out.println("Sistema Seguro (systemActive && !securityBreach): " + systemSecure);
        
        // OR lógico (||)
        boolean needsAttention = !systemActive || securityBreach;
        System.out.println("Necessita Atenção (!systemActive || securityBreach): " + needsAttention);
        
        // NOT lógico (!)
        boolean systemInactive = !systemActive;
        System.out.println("Sistema Inativo (!systemActive): " + systemInactive);

        // Avaliação de curto-circuito
        System.out.println("\nAvaliação de Curto-Circuito:");
        System.out.println("===========================");
        
        int shield = 100;
        int damage = 50;
        
        // AND com curto-circuito
        boolean shieldBreak = (shield < 0) && (damage > shield);  // Segunda parte não é avaliada
        System.out.println("Shield Break check: " + shieldBreak);
        
        // OR com curto-circuito
        boolean needsRecharge = (shield < 50) || (damage > 75);  // Segunda parte não é avaliada se a primeira for true
        System.out.println("Needs Recharge check: " + needsRecharge);

        // Exemplo prático com curto-circuito
        System.out.println("\nExemplo Prático:");
        System.out.println("===============");
        
        String username = null;
        
        // Evita NullPointerException devido ao curto-circuito
        boolean isValidUser = (username != null) && username.length() > 3;
        System.out.println("Is Valid User: " + isValidUser);

        // Operadores bit a bit booleanos (sem curto-circuito)
        System.out.println("\nOperadores Bit a Bit Booleanos:");
        System.out.println("============================");
        
        boolean condition1 = true;
        boolean condition2 = false;
        
        // AND bit a bit (&)
        boolean bitwiseAnd = condition1 & condition2;
        System.out.println("Bitwise AND (&): " + bitwiseAnd);
        
        // OR bit a bit (|)
        boolean bitwiseOr = condition1 | condition2;
        System.out.println("Bitwise OR (|): " + bitwiseOr);
        
        // XOR bit a bit (^)
        boolean bitwiseXor = condition1 ^ condition2;
        System.out.println("Bitwise XOR (^): " + bitwiseXor);
    }
}
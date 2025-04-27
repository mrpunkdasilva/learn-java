package com.netrunner.variables;

public class PrimitiveTypesExample {
    public static void main(String[] args) {
        // Tipos numéricos inteiros
        byte corePower = 127;                    // 8 bits: -128 até 127
        short chipVersion = 32767;               // 16 bits: -32,768 até 32,767
        int userCount = 2147483647;              // 32 bits: -2^31 até 2^31-1
        long globalId = 9223372036854775807L;    // 64 bits: -2^63 até 2^63-1

        // Tipos de ponto flutuante
        float processorTemp = 75.5f;             // 32 bits: ~7 dígitos decimais
        double preciseCalc = 75.5467892;         // 64 bits: ~15 dígitos decimais

        // Tipo caractere
        char securityLevel = 'A';                // 16 bits: caractere Unicode

        // Tipo booleano
        boolean isConnected = true;              // 1 bit: true ou false

        // Exibindo os valores
        System.out.println("Core Power: " + corePower);
        System.out.println("Chip Version: " + chipVersion);
        System.out.println("User Count: " + userCount);
        System.out.println("Global ID: " + globalId);
        System.out.println("Processor Temperature: " + processorTemp);
        System.out.println("Precise Calculation: " + preciseCalc);
        System.out.println("Security Level: " + securityLevel);
        System.out.println("Connection Status: " + isConnected);
    }
}
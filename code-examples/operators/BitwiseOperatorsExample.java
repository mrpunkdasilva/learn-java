package com.netrunner.operators;

public class BitwiseOperatorsExample {
    public static void main(String[] args) {
        // Operadores bit a bit básicos
        System.out.println("Operadores Bit a Bit Básicos:");
        System.out.println("===========================");
        
        int permissions = 0b1100;  // 12 em binário
        int mask = 0b1010;        // 10 em binário
        
        // AND bit a bit (&)
        int andResult = permissions & mask;
        System.out.println("AND bit a bit (permissions & mask):");
        System.out.println("permissions: " + String.format("%4s", Integer.toBinaryString(permissions)));
        System.out.println("mask:       " + String.format("%4s", Integer.toBinaryString(mask)));
        System.out.println("resultado:  " + String.format("%4s", Integer.toBinaryString(andResult)));
        
        // OR bit a bit (|)
        int orResult = permissions | mask;
        System.out.println("\nOR bit a bit (permissions | mask):");
        System.out.println("permissions: " + String.format("%4s", Integer.toBinaryString(permissions)));
        System.out.println("mask:       " + String.format("%4s", Integer.toBinaryString(mask)));
        System.out.println("resultado:  " + String.format("%4s", Integer.toBinaryString(orResult)));
        
        // XOR bit a bit (^)
        int xorResult = permissions ^ mask;
        System.out.println("\nXOR bit a bit (permissions ^ mask):");
        System.out.println("permissions: " + String.format("%4s", Integer.toBinaryString(permissions)));
        System.out.println("mask:       " + String.format("%4s", Integer.toBinaryString(mask)));
        System.out.println("resultado:  " + String.format("%4s", Integer.toBinaryString(xorResult)));
        
        // NOT bit a bit (~)
        int notResult = ~permissions;
        System.out.println("\nNOT bit a bit (~permissions):");
        System.out.println("permissions: " + String.format("%32s", Integer.toBinaryString(permissions)));
        System.out.println("resultado:  " + String.format("%32s", Integer.toBinaryString(notResult)));

        // Operadores de deslocamento
        System.out.println("\nOperadores de Deslocamento:");
        System.out.println("=========================");
        
        int number = 8;  // 1000 em binário
        
        // Deslocamento à esquerda (<<)
        int leftShift = number << 2;
        System.out.println("\nDeslocamento à esquerda (number << 2):");
        System.out.println("original:  " + String.format("%4s", Integer.toBinaryString(number)));
        System.out.println("resultado: " + String.format("%4s", Integer.toBinaryString(leftShift)));
        
        // Deslocamento à direita com sinal (>>)
        int rightShift = number >> 1;
        System.out.println("\nDeslocamento à direita (number >> 1):");
        System.out.println("original:  " + String.format("%4s", Integer.toBinaryString(number)));
        System.out.println("resultado: " + String.format("%4s", Integer.toBinaryString(rightShift)));
        
        // Deslocamento à direita sem sinal (>>>)
        int unsignedRightShift = -number >>> 1;
        System.out.println("\nDeslocamento à direita sem sinal (-number >>> 1):");
        System.out.println("original:  " + String.format("%32s", Integer.toBinaryString(-number)));
        System.out.println("resultado: " + String.format("%32s", Integer.toBinaryString(unsignedRightShift)));

        // Exemplo prático: Manipulação de flags
        System.out.println("\nExemplo Prático - Manipulação de Flags:");
        System.out.println("====================================");
        
        // Definindo flags de permissões
        final int READ = 0b100;    // 4
        final int WRITE = 0b010;   // 2
        final int EXECUTE = 0b001;  // 1
        
        int userPermissions = 0;
        
        // Adicionando permissões
        userPermissions |= READ;    // Adiciona permissão de leitura
        userPermissions |= WRITE;   // Adiciona permissão de escrita
        
        System.out.println("Permissões após adicionar READ e WRITE: " + 
                          String.format("%3s", Integer.toBinaryString(userPermissions)));
        
        // Verificando permissões
        boolean canRead = (userPermissions & READ) != 0;
        boolean canWrite = (userPermissions & WRITE) != 0;
        boolean canExecute = (userPermissions & EXECUTE) != 0;
        
        System.out.println("Pode ler? " + canRead);
        System.out.println("Pode escrever? " + canWrite);
        System.out.println("Pode executar? " + canExecute);
    }
}
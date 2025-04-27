package com.netrunner.variables;

public class DataTypeSizesDemo {
    public static void main(String[] args) {
        // Demonstração dos tamanhos dos tipos de dados
        System.out.println("Tamanhos dos Tipos de Dados em Java:");
        System.out.println("====================================");
        
        // Tipos primitivos
        System.out.println("byte: " + Byte.SIZE + " bits");
        System.out.println("short: " + Short.SIZE + " bits");
        System.out.println("int: " + Integer.SIZE + " bits");
        System.out.println("long: " + Long.SIZE + " bits");
        System.out.println("float: " + Float.SIZE + " bits");
        System.out.println("double: " + Double.SIZE + " bits");
        System.out.println("char: " + Character.SIZE + " bits");

        // Valores máximos e mínimos
        System.out.println("\nValores Máximos e Mínimos:");
        System.out.println("====================================");
        System.out.println("byte: " + Byte.MIN_VALUE + " até " + Byte.MAX_VALUE);
        System.out.println("short: " + Short.MIN_VALUE + " até " + Short.MAX_VALUE);
        System.out.println("int: " + Integer.MIN_VALUE + " até " + Integer.MAX_VALUE);
        System.out.println("long: " + Long.MIN_VALUE + " até " + Long.MAX_VALUE);
        System.out.println("float: " + Float.MIN_VALUE + " até " + Float.MAX_VALUE);
        System.out.println("double: " + Double.MIN_VALUE + " até " + Double.MAX_VALUE);
    }
}
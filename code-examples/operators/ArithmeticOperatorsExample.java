package com.netrunner.operators;

public class ArithmeticOperatorsExample {
    public static void main(String[] args) {
        // Operações básicas
        System.out.println("Operações Básicas:");
        System.out.println("=================");
        
        int powerLevel = 100;
        int boost = 25;
        
        // Adição
        int totalPower = powerLevel + boost;
        System.out.println("Power Level + Boost: " + totalPower);
        
        // Subtração
        int remainingPower = powerLevel - boost;
        System.out.println("Power Level - Boost: " + remainingPower);
        
        // Multiplicação
        int amplifiedPower = powerLevel * 2;
        System.out.println("Power Level * 2: " + amplifiedPower);
        
        // Divisão
        int powerShare = powerLevel / 4;
        System.out.println("Power Level / 4: " + powerShare);
        
        // Módulo (resto)
        int powerRemainder = powerLevel % 3;
        System.out.println("Power Level % 3: " + powerRemainder);

        // Incremento e Decremento
        System.out.println("\nIncremento e Decremento:");
        System.out.println("=======================");
        
        int shield = 50;
        System.out.println("Shield inicial: " + shield);
        
        // Pré-incremento
        System.out.println("++shield: " + (++shield));
        
        // Pós-incremento
        System.out.println("shield++: " + (shield++));
        System.out.println("Shield após pós-incremento: " + shield);
        
        // Pré-decremento
        System.out.println("--shield: " + (--shield));
        
        // Pós-decremento
        System.out.println("shield--: " + (shield--));
        System.out.println("Shield após pós-decremento: " + shield);

        // Operadores compostos
        System.out.println("\nOperadores Compostos:");
        System.out.println("===================");
        
        int energy = 100;
        System.out.println("Energia inicial: " + energy);
        
        energy += 25;  // energy = energy + 25
        System.out.println("Após energy += 25: " + energy);
        
        energy -= 10;  // energy = energy - 10
        System.out.println("Após energy -= 10: " + energy);
        
        energy *= 2;   // energy = energy * 2
        System.out.println("Após energy *= 2: " + energy);
        
        energy /= 4;   // energy = energy / 4
        System.out.println("Após energy /= 4: " + energy);
        
        energy %= 7;   // energy = energy % 7
        System.out.println("Após energy %= 7: " + energy);
    }
}
package com.netrunner.variables;

public class TypeCastingDemo {
    public static void main(String[] args) {
        // Casting implícito (Widening)
        byte securityLevel = 5;
        int expandedLevel = securityLevel;  // byte para int
        System.out.println("Implicit casting (byte to int): " + expandedLevel);

        // Casting explícito (Narrowing)
        double powerLevel = 99.99;
        int roundedPower = (int) powerLevel;  // double para int
        System.out.println("Explicit casting (double to int): " + roundedPower);

        // Casting entre tipos de objetos
        Object[] objects = new String[3];
        objects[0] = "CyberDeck";
        objects[1] = "NetMask";
        objects[2] = "ICEBreaker";

        // Casting de objeto
        String firstItem = (String) objects[0];
        System.out.println("Object casting: " + firstItem);

        // Demonstração de perda de precisão
        int largeNumber = 1000;
        byte smallNumber = (byte) largeNumber;
        System.out.println("Loss of precision (int to byte): " + smallNumber);

        // Conversão de String para números
        String strNumber = "42";
        int parsedInt = Integer.parseInt(strNumber);
        double parsedDouble = Double.parseDouble(strNumber);
        System.out.println("String to int: " + parsedInt);
        System.out.println("String to double: " + parsedDouble);
    }
}
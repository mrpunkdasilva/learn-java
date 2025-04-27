package com.netrunner.variables;

import java.util.Arrays;

public class ReferenceTypesExample {
    public static void main(String[] args) {
        // Strings
        String codeName = "NetRunner";
        String[] aliases = {"Ghost", "Phantom", "Shadow"};
        
        // Arrays
        int[] securityLevels = new int[3];
        securityLevels[0] = 1;
        securityLevels[1] = 2;
        securityLevels[2] = 3;

        // Objetos personalizados
        CyberProfile profile = new CyberProfile("Neo", 99);

        // Demonstração de referências
        System.out.println("Code Name: " + codeName);
        System.out.println("Aliases: " + Arrays.toString(aliases));
        System.out.println("Security Levels: " + Arrays.toString(securityLevels));
        System.out.println("Profile: " + profile);

        // Demonstração de null
        String nullReference = null;
        System.out.println("Null Reference: " + nullReference);
    }
}

class CyberProfile {
    private String name;
    private int level;

    public CyberProfile(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        return "CyberProfile{name='" + name + "', level=" + level + "}";
    }
}
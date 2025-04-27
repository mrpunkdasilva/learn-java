package com.netrunner.strings;

public class StringMethodsExample {
    public static void main(String[] args) {
        System.out.println("Métodos de Busca:");
        System.out.println("================");
        
        String dataStream = "CYBERPUNK_2077_NETRUNNER_PROTOCOL";
        
        // indexOf e lastIndexOf
        System.out.println("indexOf('NET'): " + dataStream.indexOf("NET"));
        System.out.println("lastIndexOf('_'): " + dataStream.lastIndexOf("_"));
        
        // contains
        System.out.println("contains('PUNK'): " + dataStream.contains("PUNK"));
        
        // startsWith e endsWith
        System.out.println("startsWith('CYBER'): " + dataStream.startsWith("CYBER"));
        System.out.println("endsWith('PROTOCOL'): " + dataStream.endsWith("PROTOCOL"));

        System.out.println("\nMétodos de Transformação:");
        System.out.println("========================");
        
        String hackSequence = "Initialize_System_Breach";
        
        // Case transformation
        System.out.println("toUpperCase(): " + hackSequence.toUpperCase());
        System.out.println("toLowerCase(): " + hackSequence.toLowerCase());
        
        // Replace
        System.out.println("replace('_', ' '): " + 
                          hackSequence.replace("_", " "));
        System.out.println("replaceAll('[aeiou]', '*'): " + 
                          hackSequence.replaceAll("[aeiou]", "*"));
        
        // Strip/Trim
        String paddedCode = "   SECURITY_BREACH   ";
        System.out.println("trim(): '" + paddedCode.trim() + "'");
        System.out.println("strip(): '" + paddedCode.strip() + "'");

        System.out.println("\nMétodos de Extração:");
        System.out.println("===================");
        
        String logEntry = "2077-12-31:ERROR:Memory_Overflow:0x1234";
        
        // Split
        String[] logParts = logEntry.split(":");
        System.out.println("Split results:");
        for (String part : logParts) {
            System.out.println("- " + part);
        }
        
        // Substring
        String date = logEntry.substring(0, 10);
        String errorCode = logEntry.substring(logEntry.lastIndexOf(":") + 1);
        System.out.println("Date: " + date);
        System.out.println("Error Code: " + errorCode);

        System.out.println("\nMétodos de Comparação:");
        System.out.println("=====================");
        
        String cmd1 = "EXECUTE";
        String cmd2 = "execute";
        String cmd3 = "EXECUTE";
        
        // Equals e EqualsIgnoreCase
        System.out.println("equals(): " + cmd1.equals(cmd2));
        System.out.println("equalsIgnoreCase(): " + cmd1.equalsIgnoreCase(cmd2));
        
        // compareTo
        System.out.println("compareTo(): " + cmd1.compareTo(cmd3));
        
        // contentEquals
        System.out.println("contentEquals(): " + 
                          cmd1.contentEquals(new StringBuilder("EXECUTE")));
    }
}
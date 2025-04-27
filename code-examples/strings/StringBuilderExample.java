package com.netrunner.strings;

public class StringBuilderExample {
    public static void main(String[] args) {
        System.out.println("StringBuilder Básico:");
        System.out.println("====================");
        
        // Criação e append
        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append("LOG_START")
                 .append(":")
                 .append("2077-12-31")
                 .append(":")
                 .append("INIT");
        
        System.out.println("Log inicial: " + logBuilder);
        
        // Inserção
        logBuilder.insert(0, "PRIORITY_1:");
        System.out.println("Após insert: " + logBuilder);
        
        // Substituição
        logBuilder.replace(logBuilder.indexOf("INIT"), 
                          logBuilder.length(), 
                          "COMPLETE");
        System.out.println("Após replace: " + logBuilder);

        System.out.println("\nManipulação de Capacidade:");
        System.out.println("=========================");
        
        StringBuilder buffer = new StringBuilder(20);
        System.out.println("Capacidade inicial: " + buffer.capacity());
        
        // Forçando expansão
        buffer.append("LONG_SECURITY_CODE_1234567890");
        System.out.println("Capacidade após expansão: " + buffer.capacity());
        
        // Otimizando capacidade
        buffer.trimToSize();
        System.out.println("Capacidade após trim: " + buffer.capacity());

        System.out.println("\nExemplo Prático - Log Generator:");
        System.out.println("==============================");
        
        StringBuilder logGenerator = new StringBuilder();
        
        // Simulando geração de log
        String[] events = {"INIT", "CONNECT", "AUTHENTICATE", "EXECUTE", "DISCONNECT"};
        int sessionId = 12345;
        
        logGenerator.append("SESSION_").append(sessionId).append("\n");
        
        for (String event : events) {
            logGenerator.append("[")
                       .append(System.currentTimeMillis())
                       .append("] ")
                       .append(event)
                       .append("\n");
        }
        
        logGenerator.append("END_SESSION_").append(sessionId);
        
        System.out.println(logGenerator.toString());

        System.out.println("\nPerformance Comparison:");
        System.out.println("=====================");
        
        // String concatenation
        long start = System.nanoTime();
        String result = "";
        for (int i = 0; i < 1000; i++) {
            result += "X";
        }
        long stringTime = System.nanoTime() - start;
        
        // StringBuilder
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append("X");
        }
        long builderTime = System.nanoTime() - start;
        
        System.out.printf("String concatenation time: %,d ns%n", stringTime);
        System.out.printf("StringBuilder time: %,d ns%n", builderTime);
        System.out.printf("StringBuilder is %d times faster%n", 
                         stringTime / builderTime);
    }
}
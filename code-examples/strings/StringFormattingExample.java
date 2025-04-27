package com.netrunner.strings;

import java.util.Date;
import java.util.Locale;

public class StringFormattingExample {
    public static void main(String[] args) {
        System.out.println("Formatação Básica:");
        System.out.println("=================");
        
        // Formatação de números
        int hackLevel = 42;
        double accuracy = 98.7654;
        
        System.out.printf("Nível: %d, Precisão: %.2f%%%n", hackLevel, accuracy);
        System.out.printf("Hex: %#x, Científico: %e%n", hackLevel, accuracy);
        
        // Alinhamento e padding
        String status = "ONLINE";
        System.out.printf("Status: [%-10s]%n", status);  // Alinhado à esquerda
        System.out.printf("Status: [%10s]%n", status);   // Alinhado à direita
        
        // Números com zeros à esquerda
        int code = 7;
        System.out.printf("Código: %04d%n", code);

        System.out.println("\nFormatação de Data e Hora:");
        System.out.println("========================");
        
        Date now = new Date();
        System.out.printf("Data: %tF%n", now);
        System.out.printf("Hora: %tT%n", now);
        System.out.printf("Data e Hora: %1$tF %1$tT%n", now);
        
        // Formatação completa
        System.out.printf("Log: [%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS] %n", now);

        System.out.println("\nFormatação Monetária:");
        System.out.println("====================");
        
        double credits = 1234567.89;
        
        // Diferentes locales
        System.out.printf(Locale.US, "US: $%,.2f%n", credits);
        System.out.printf(new Locale("pt", "BR"), "BR: R$%,.2f%n", credits);
        System.out.printf(Locale.GERMANY, "DE: %,.2f€%n", credits);

        System.out.println("\nString.format Examples:");
        System.out.println("=====================");
        
        // Criando strings formatadas
        String logEntry = String.format(
            "[%1$tF %1$tT] User:%2$-10s Level:%3$03d",
            now, "NETRUNNER", 7
        );
        System.out.println(logEntry);
        
        // Formatação condicional
        int securityLevel = 5;
        String securityStatus = String.format(
            "Security Level: %d [%s]",
            securityLevel,
            securityLevel > 7 ? "HIGH" : "LOW"
        );
        System.out.println(securityStatus);

        System.out.println("\nExemplo Prático - Log Formatter:");
        System.out.println("==============================");
        
        class LogEntry {
            Date timestamp;
            String level;
            int code;
            String message;
            
            LogEntry(String level, int code, String message) {
                this.timestamp = new Date();
                this.level = level;
                this.code = code;
                this.message = message;
            }
            
            @Override
            public String toString() {
                return String.format(
                    "[%1$tF %1$tT] %-5s #%04d: %s",
                    timestamp, level, code, message
                );
            }
        }
        
        LogEntry[] logs = {
            new LogEntry("INFO", 1, "System initialized"),
            new LogEntry("WARN", 2, "High memory usage"),
            new LogEntry("ERROR", 3, "Connection failed")
        };
        
        for (LogEntry log : logs) {
            System.out.println(log);
        }
    }
}
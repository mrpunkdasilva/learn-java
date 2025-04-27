package com.netrunner.variables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VarKeywordExample {
    public static void main(String[] args) {
        // Uso básico do var
        var message = "Hello, NetRunner!";  // infere String
        var count = 42;                     // infere int
        var price = 19.99;                  // infere double
        
        // Com coleções
        var users = new ArrayList<String>();  // infere ArrayList<String>
        users.add("Neo");
        users.add("Trinity");

        // Com Map
        var config = new HashMap<String, Object>();  // infere HashMap<String, Object>
        config.put("debug", true);
        config.put("maxConnections", 100);

        // Em loops
        for (var i = 0; i < 3; i++) {  // infere int
            System.out.println("Iteration: " + i);
        }

        // Com lambda (não permitido diretamente)
        List<String> codes = List.of("RED", "BLUE", "GREEN");
        for (var code : codes) {  // infere String
            System.out.println("Code: " + code);
        }

        // Demonstração de tipos inferidos
        System.out.println("\nTipos Inferidos:");
        System.out.println("message: " + message.getClass().getSimpleName());
        System.out.println("count: " + ((Object)count).getClass().getSimpleName());
        System.out.println("price: " + ((Object)price).getClass().getSimpleName());
        System.out.println("users: " + users.getClass().getSimpleName());
        System.out.println("config: " + config.getClass().getSimpleName());
    }

    // var não pode ser usado em parâmetros de método
    private static void processData(String data) {  // não pode usar var aqui
        var result = data.toUpperCase();  // mas pode usar dentro do método
        System.out.println(result);
    }
}
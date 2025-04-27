package com.example;

import com.framework.core.DIContainer;

public class Main {
    public static void main(String[] args) {
        // Criar container
        DIContainer container = new DIContainer();
        
        // Obter instância do UserService
        UserService userService = container.getInstance(UserService.class);
        
        // Usar o serviço
        User user = userService.findUser(1L);
        System.out.println("Found user: " + user);
    }
}
package com.netrunner.example;

import com.netrunner.engine.DataProcessorEngine;
import com.netrunner.core.ProcessingResult;

public class UserService {
    private final DataProcessorEngine processor;

    public UserService(DataProcessorEngine processor) {
        this.processor = processor;
    }

    public void registerUser(UserData userData) {
        ProcessingResult<UserData> result = processor.process(userData);
        
        if (result.isValid()) {
            UserData processedData = result.getProcessedData();
            // Continuar com o fluxo de registro
            System.out.println("Usuário processado com sucesso: " + processedData.getEmail());
        } else {
            // Tratar erros de validação
            System.out.println("Erros de validação:");
            result.getErrors().forEach(System.out::println);
        }
    }
}
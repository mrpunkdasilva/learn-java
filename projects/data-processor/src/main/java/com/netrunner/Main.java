package com.netrunner;

import com.netrunner.engine.DataProcessorEngine;
import com.netrunner.example.UserData;
import com.netrunner.example.UserProfile;
import com.netrunner.example.UserService;
import com.netrunner.transformers.DateFormatTransformer;
import com.netrunner.transformers.EncryptTransformer;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criar e configurar o processador
        DataProcessorEngine engine = new DataProcessorEngine();
        engine.registerTransformer(String.class, new EncryptTransformer());
        engine.registerTransformer(Date.class, new DateFormatTransformer());

        // Criar serviço
        UserService userService = new UserService(engine);

        // Criar dados de exemplo
        UserData userData = new UserData();
        userData.setEmail("user@example.com");
        userData.setPassword("secretpass123");
        userData.setBirthDate(new Date());
        
        UserProfile profile = new UserProfile();
        profile.setName("John Doe");
        profile.setAddress("123 Cyber Street");
        profile.setPhone("555-0123");
        userData.setProfile(profile);

        // Processar dados
        userService.registerUser(userData);
    }
}
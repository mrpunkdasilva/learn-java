package com.example;

import com.framework.annotations.Component;
import com.framework.annotations.Inject;

@Component(scope = "prototype")
public class UserRepository {
    private final DatabaseConnection connection;
    
    @Inject
    public UserRepository(DatabaseConnection connection) {
        this.connection = connection;
    }
    
    public User findById(Long id) {
        // Implementação simulada
        return new User(id, "User " + id);
    }
}
package com.example;

import com.framework.annotations.Component;
import com.framework.annotations.Initialize;

@Component
public class DatabaseConnection {
    private boolean connected = false;
    
    @Initialize(order = 0)
    public void connect() {
        System.out.println("Connecting to database...");
        connected = true;
    }
    
    public boolean isConnected() {
        return connected;
    }
}
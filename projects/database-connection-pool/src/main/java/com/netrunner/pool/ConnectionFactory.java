package com.netrunner.pool;

import com.netrunner.pool.config.ConnectionConfig;
import com.netrunner.pool.exception.ConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private final ConnectionConfig config;

    public ConnectionFactory(ConnectionConfig config) {
        this.config = config;
    }

    public PooledConnection createConnection() throws ConnectionException {
        try {
            Connection connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
            );
            return new PooledConnection(connection, config.getTimeout());
        } catch (SQLException e) {
            throw new ConnectionException("Failed to create database connection", e);
        }
    }
}
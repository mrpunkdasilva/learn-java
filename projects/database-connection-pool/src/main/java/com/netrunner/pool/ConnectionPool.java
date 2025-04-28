package com.netrunner.pool;

import com.netrunner.pool.config.ConnectionConfig;
import com.netrunner.pool.exception.ConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConnectionPool {
    private static final Logger logger = LoggerFactory.getLogger(ConnectionPool.class);
    private static volatile ConnectionPool instance;
    private final List<PooledConnection> connections;
    private final int maxSize;
    private final int timeout;
    private final ConnectionFactory factory;

    private ConnectionPool(ConnectionConfig config) {
        this.maxSize = config.getMaxSize();
        this.timeout = config.getTimeout();
        this.connections = new ArrayList<>();
        this.factory = new ConnectionFactory(config);
        logger.info("Initializing connection pool with maxSize={}, timeout={}ms", maxSize, timeout);
    }

    public static ConnectionPool getInstance(ConnectionConfig config) {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool(config);
                }
            }
        }
        return instance;
    }

    public synchronized Connection getConnection() throws ConnectionException {
        cleanInvalidConnections();

        Optional<PooledConnection> availableConnection = connections.stream()
                .filter(conn -> !conn.isInUse() && conn.isValid())
                .findFirst();

        if (availableConnection.isPresent()) {
            PooledConnection connection = availableConnection.get();
            connection.setInUse(true);
            logger.debug("Reusing existing connection from pool");
            return connection;
        }

        if (connections.size() < maxSize) {
            PooledConnection connection = factory.createConnection();
            connections.add(connection);
            connection.setInUse(true);
            logger.debug("Created new connection in pool");
            return connection;
        }

        logger.error("Connection pool limit reached. Active connections: {}", connections.size());
        throw new ConnectionException("Connection pool limit reached");
    }

    public synchronized void releaseConnection(Connection connection) {
        if (connection instanceof PooledConnection) {
            PooledConnection pooledConnection = (PooledConnection) connection;
            pooledConnection.setInUse(false);
            pooledConnection.setLastUsed(System.currentTimeMillis());
            logger.debug("Connection released back to pool");
        }
    }

    private void cleanInvalidConnections() {
        connections.removeIf(conn -> !conn.isValid());
    }

    // Methods for monitoring
    public int getTotalConnections() {
        return connections.size();
    }

    public int getActiveConnections() {
        return (int) connections.stream().filter(PooledConnection::isInUse).count();
    }

    public int getIdleConnections() {
        return (int) connections.stream().filter(conn -> !conn.isInUse()).count();
    }
}
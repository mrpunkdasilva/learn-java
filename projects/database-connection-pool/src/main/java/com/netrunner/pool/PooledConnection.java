package com.netrunner.pool;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class PooledConnection implements Connection {
    private final Connection delegate;
    private boolean inUse;
    private long lastUsed;
    private final int timeout;

    public PooledConnection(Connection delegate, int timeout) {
        this.delegate = delegate;
        this.timeout = timeout;
        this.lastUsed = System.currentTimeMillis();
    }

    public boolean isValid() {
        if (System.currentTimeMillis() - lastUsed > timeout) {
            return false;
        }
        try {
            return delegate.isValid(1);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public void setLastUsed(long lastUsed) {
        this.lastUsed = lastUsed;
    }

    @Override
    public void close() throws SQLException {
        ConnectionPool.getInstance(null).releaseConnection(this);
    }

    // Delegate all other Connection interface methods to the underlying connection
    @Override
    public Statement createStatement() throws SQLException {
        return delegate.createStatement();
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return delegate.prepareStatement(sql);
    }

    // ... implement other Connection interface methods ...
}
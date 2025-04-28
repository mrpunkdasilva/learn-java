package com.netrunner.pool;

import com.netrunner.pool.config.ConnectionConfig;
import com.netrunner.pool.exception.ConnectionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionPoolTest {
    private ConnectionPool pool;

    @BeforeEach
    void setUp() {
        ConnectionConfig config = new ConnectionConfig.Builder()
            .url("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1")
            .username("sa")
            .password("")
            .maxSize(5)
            .timeout(1000)
            .build();

        pool = ConnectionPool.getInstance(config);
    }

    @Test
    void testGetConnection() {
        Connection connection = pool.getConnection();
        assertNotNull(connection);
        assertTrue(connection instanceof PooledConnection);
    }

    @Test
    void testPoolLimit() {
        List<Connection> connections = new ArrayList<>();
        
        // Get max connections
        for (int i = 0; i < 5; i++) {
            connections.add(pool.getConnection());
        }

        // Try to get one more
        assertThrows(ConnectionException.class, () -> pool.getConnection());

        // Release one and try again
        pool.releaseConnection(connections.get(0));
        assertDoesNotThrow(() -> pool.getConnection());
    }

    @Test
    void testConnectionReuse() {
        Connection conn1 = pool.getConnection();
        pool.releaseConnection(conn1);
        Connection conn2 = pool.getConnection();
        
        assertEquals(1, pool.getTotalConnections());
    }
}
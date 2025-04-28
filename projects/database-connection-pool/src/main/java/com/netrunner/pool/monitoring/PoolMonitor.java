package com.netrunner.pool.monitoring;

import com.netrunner.pool.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PoolMonitor {
    private static final Logger logger = LoggerFactory.getLogger(PoolMonitor.class);
    private final ConnectionPool pool;

    public PoolMonitor(ConnectionPool pool) {
        this.pool = pool;
    }

    public PoolStatistics getStatistics() {
        return new PoolStatistics(
            pool.getTotalConnections(),
            pool.getActiveConnections(),
            pool.getIdleConnections()
        );
    }

    public void logStatistics() {
        PoolStatistics stats = getStatistics();
        logger.info("Pool Stats: active={}, idle={}, total={}",
            stats.getActive(),
            stats.getIdle(),
            stats.getTotal());
    }
}
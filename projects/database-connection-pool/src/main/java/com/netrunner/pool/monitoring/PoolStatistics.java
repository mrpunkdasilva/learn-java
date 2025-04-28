package com.netrunner.pool.monitoring;

public class PoolStatistics {
    private final int total;
    private final int active;
    private final int idle;

    public PoolStatistics(int total, int active, int idle) {
        this.total = total;
        this.active = active;
        this.idle = idle;
    }

    public int getTotal() {
        return total;
    }

    public int getActive() {
        return active;
    }

    public int getIdle() {
        return idle;
    }
}
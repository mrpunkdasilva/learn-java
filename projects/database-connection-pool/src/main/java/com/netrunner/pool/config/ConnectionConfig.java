package com.netrunner.pool.config;

public class ConnectionConfig {
    private final String url;
    private final String username;
    private final String password;
    private final int maxSize;
    private final int timeout;

    private ConnectionConfig(Builder builder) {
        this.url = builder.url;
        this.username = builder.username;
        this.password = builder.password;
        this.maxSize = builder.maxSize;
        this.timeout = builder.timeout;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getTimeout() {
        return timeout;
    }

    public static class Builder {
        private String url;
        private String username;
        private String password;
        private int maxSize = 10;
        private int timeout = 30000;

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder maxSize(int maxSize) {
            this.maxSize = maxSize;
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public ConnectionConfig build() {
            return new ConnectionConfig(this);
        }
    }
}
public class CircuitBreaker {
    private final String name;
    private final int failureThreshold;
    private final long resetTimeout;
    private final Map<String, Supplier<String>> fallbacks = new HashMap<>();
    
    private CircuitState state = CircuitState.CLOSED;
    private int failureCount = 0;
    private long lastFailureTime;

    public CircuitBreaker(String name, int failureThreshold, long resetTimeout) {
        this.name = name;
        this.failureThreshold = failureThreshold;
        this.resetTimeout = resetTimeout;
    }

    public void addFallback(String operationId, Supplier<String> fallback) {
        fallbacks.put(operationId, fallback);
    }

    public synchronized <T> T execute(String operationId, Supplier<T> operation) throws CircuitBreakerException {
        if (state == CircuitState.OPEN) {
            if (System.currentTimeMillis() - lastFailureTime >= resetTimeout) {
                state = CircuitState.HALF_OPEN;
            } else {
                return executeFallback(operationId);
            }
        }

        try {
            T result = operation.get();
            if (state == CircuitState.HALF_OPEN) {
                state = CircuitState.CLOSED;
                failureCount = 0;
            }
            return result;
        } catch (Exception e) {
            handleFailure();
            throw new CircuitBreakerException("Operação falhou: " + e.getMessage());
        }
    }

    private synchronized void handleFailure() {
        failureCount++;
        lastFailureTime = System.currentTimeMillis();
        
        if (failureCount >= failureThreshold) {
            state = CircuitState.OPEN;
        }
    }

    @SuppressWarnings("unchecked")
    private <T> T executeFallback(String operationId) {
        Supplier<String> fallback = fallbacks.get(operationId);
        if (fallback != null) {
            return (T) fallback.get();
        }
        throw new CircuitBreakerException("Circuit aberto e nenhum fallback disponível");
    }

    public CircuitState getState() {
        return state;
    }
}
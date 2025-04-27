public enum CircuitState {
    CLOSED,     // Operação normal
    OPEN,       // Falhas detectadas, rejeitando requisições
    HALF_OPEN   // Período de teste após timeout
}
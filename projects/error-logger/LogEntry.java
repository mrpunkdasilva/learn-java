public record LogEntry(
    LocalDateTime timestamp,
    String type,
    String message,
    String context,
    String stackTrace
) {
    @Override
    public String toString() {
        return String.format("""
            [%s] %s: %s
            Context: %s
            StackTrace:
            %s
            ----------------------------------------
            """,
            timestamp, type, message, context, stackTrace);
    }
}
public class ErrorLogger {
    private static final String LOG_FILE = "errors.log";
    private final Queue<LogEntry> logQueue = new ConcurrentLinkedQueue<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public ErrorLogger() {
        // Iniciar processo de flush periódico
        scheduler.scheduleAtFixedRate(this::flushLogs, 0, 5, TimeUnit.SECONDS);
    }

    public void log(Exception e, String context) {
        LogEntry entry = new LogEntry(
            LocalDateTime.now(),
            e.getClass().getSimpleName(),
            e.getMessage(),
            context,
            ExceptionUtils.getStackTrace(e)
        );
        logQueue.offer(entry);
    }

    private void flushLogs() {
        List<LogEntry> entries = new ArrayList<>();
        LogEntry entry;
        while ((entry = logQueue.poll()) != null) {
            entries.add(entry);
        }

        if (!entries.isEmpty()) {
            writeToFile(entries);
        }
    }

    private void writeToFile(List<LogEntry> entries) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            for (LogEntry entry : entries) {
                writer.write(entry.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever log: " + e.getMessage());
        }
    }
}
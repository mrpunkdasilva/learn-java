public class QueueExamples {
    public void demonstrateQueues() {
        // Queue básica
        Queue<String> queue = new LinkedList<>();
        queue.offer("Primeiro");   // Adiciona
        queue.offer("Segundo");
        queue.poll();              // Remove e retorna
        queue.peek();              // Retorna sem remover
        
        // PriorityQueue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(3);
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        // Elementos são removidos em ordem crescente
        
        // Deque (double-ended queue)
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("Primeiro");
        deque.addLast("Último");
        deque.removeFirst();
        deque.removeLast();
        
        // BlockingQueue (thread-safe)
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        try {
            blockingQueue.put("Item");      // Bloqueia se cheio
            String item = blockingQueue.take(); // Bloqueia se vazio
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
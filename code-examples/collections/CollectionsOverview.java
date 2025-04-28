public class CollectionsOverview {
    public void demonstrateCollections() {
        // List exemplo
        List<String> lista = new ArrayList<>();
        lista.add("Primeiro");
        lista.add("Segundo");
        
        // Set exemplo
        Set<Integer> conjunto = new HashSet<>();
        conjunto.add(1);
        conjunto.add(2);
        
        // Queue exemplo
        Queue<String> fila = new LinkedList<>();
        fila.offer("Primeiro");
        fila.offer("Segundo");
        
        // Map exemplo
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("Um", 1);
        mapa.put("Dois", 2);
        
        // Operações comuns
        Collections.sort(lista);  // Ordenação
        Collections.reverse(lista);  // Inversão
        Collections.shuffle(lista);  // Embaralhamento
    }
}
public class MapExamples {
    public void demonstrateMaps() {
        // HashMap
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Um", 1);
        hashMap.put("Dois", 2);
        hashMap.get("Um");  // Retorna 1
        
        // TreeMap (ordenado por chave)
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Três");
        treeMap.put(1, "Um");
        treeMap.put(2, "Dois");
        
        // LinkedHashMap (mantém ordem de inserção)
        LinkedHashMap<String, Double> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("A", 1.0);
        linkedHashMap.put("B", 2.0);
        
        // Iteração sobre entradas
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // Iteração sobre chaves
        for (String key : hashMap.keySet()) {
            System.out.println(key);
        }
        
        // Iteração sobre valores
        for (Integer value : hashMap.values()) {
            System.out.println(value);
        }
    }
}
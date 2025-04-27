public class SimpleCache {
    private String[] keys;
    private String[] values;
    private long[] timestamps;
    private int[] accessCount;
    private int capacity;
    private int size;
    
    public SimpleCache(int maxSize) {
        capacity = maxSize;
        keys = new String[capacity];
        values = new String[capacity];
        timestamps = new long[capacity];
        accessCount = new int[capacity];
        size = 0;
    }
    
    // Adicionar ou atualizar item no cache
    public void put(String key, String value) {
        int index = findKey(key);
        
        if (index != -1) {
            // Atualizar valor existente
            values[index] = value;
            timestamps[index] = System.currentTimeMillis();
            accessCount[index]++;
        } else if (size < capacity) {
            // Adicionar novo item
            keys[size] = key;
            values[size] = value;
            timestamps[size] = System.currentTimeMillis();
            accessCount[size] = 1;
            size++;
        } else {
            // Cache cheio, substituir item menos acessado
            int leastUsedIndex = findLeastUsedIndex();
            keys[leastUsedIndex] = key;
            values[leastUsedIndex] = value;
            timestamps[leastUsedIndex] = System.currentTimeMillis();
            accessCount[leastUsedIndex] = 1;
        }
    }
    
    // Buscar valor no cache
    public String get(String key) {
        int index = findKey(key);
        if (index != -1) {
            accessCount[index]++;
            return values[index];
        }
        return null;
    }
    
    // Encontrar índice de uma chave
    private int findKey(String key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
    
    // Encontrar índice do item menos acessado
    private int findLeastUsedIndex() {
        int minAccess = accessCount[0];
        int leastUsedIndex = 0;
        
        for (int i = 1; i < size; i++) {
            if (accessCount[i] < minAccess) {
                minAccess = accessCount[i];
                leastUsedIndex = i;
            }
        }
        
        return leastUsedIndex;
    }
    
    // Mostrar estatísticas do cache
    public void showStats() {
        System.out.println("\n=== Cache Stats ===");
        System.out.println("Capacity: " + capacity);
        System.out.println("Current Size: " + size);
        System.out.println("\nCache Contents:");
        System.out.println("Key | Value | Access Count | Age (ms)");
        System.out.println("------------------------------------");
        
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            long age = currentTime - timestamps[i];
            System.out.println(keys[i] + " | " + 
                             values[i] + " | " + 
                             accessCount[i] + " | " + 
                             age);
        }
    }
}
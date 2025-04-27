public class ListExamples {
    public void demonstrateLists() {
        // ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Primeiro");
        arrayList.add(1, "Segundo");  // Adiciona em posição específica
        arrayList.remove("Primeiro");  // Remove por objeto
        arrayList.remove(0);  // Remove por índice
        
        // LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(1);  // Adiciona no início
        linkedList.addLast(2);   // Adiciona no final
        linkedList.removeFirst(); // Remove do início
        linkedList.removeLast();  // Remove do final
        
        // Vector (thread-safe)
        Vector<Double> vector = new Vector<>();
        vector.add(1.0);
        vector.add(2.0);
        
        // Iteração
        for (String item : arrayList) {
            System.out.println(item);
        }
        
        // Iterator
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
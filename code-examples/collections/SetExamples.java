public class SetExamples {
    public void demonstrateSets() {
        // HashSet
        Set<String> hashSet = new HashSet<>();
        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("A");  // Não adiciona duplicata
        
        // TreeSet (ordenado)
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);
        System.out.println(treeSet.first());  // Menor elemento
        System.out.println(treeSet.last());   // Maior elemento
        
        // LinkedHashSet (mantém ordem de inserção)
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("C");
        linkedHashSet.add("A");
        linkedHashSet.add("B");
        
        // Operações de conjunto
        Set<String> set1 = new HashSet<>(Arrays.asList("A", "B", "C"));
        Set<String> set2 = new HashSet<>(Arrays.asList("B", "C", "D"));
        
        set1.addAll(set2);      // União
        set1.retainAll(set2);   // Interseção
        set1.removeAll(set2);   // Diferença
    }
}
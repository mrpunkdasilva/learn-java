public class LambdaExample {
    // Basic lambda expressions
    Runnable runnable = () -> System.out.println("Hello Lambda!");
    Comparator<String> comparator = (s1, s2) -> s1.length() - s2.length();
    
    // Method references
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
    Consumer<String> printer = System.out::println;
    
    // Functional interfaces
    @FunctionalInterface
    interface Transformer<T, R> {
        R transform(T input);
    }
    
    Transformer<String, Integer> lengthCounter = String::length;
    
    // Lambda with collections
    public void demonstrateLambdas() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // Filter
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
            
        // Map
        List<String> numberStrings = numbers.stream()
            .map(n -> "Number: " + n)
            .collect(Collectors.toList());
            
        // Reduce
        int sum = numbers.stream()
            .reduce(0, (a, b) -> a + b);
    }
}
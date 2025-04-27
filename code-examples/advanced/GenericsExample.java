public class GenericsExample {
    // Generic class
    public class Box<T> {
        private T content;
        
        public void set(T content) { this.content = content; }
        public T get() { return content; }
    }

    // Bounded type parameter
    public class NumberBox<T extends Number> {
        private T number;
        
        public double sqrt() {
            return Math.sqrt(number.doubleValue());
        }
    }

    // Wildcard examples
    public void processElements(List<? extends Number> numbers) {
        for (Number n : numbers) {
            System.out.println(n.doubleValue());
        }
    }

    public void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }

    // Generic method
    public <T, U> Map<T, U> zip(List<T> keys, List<U> values) {
        Map<T, U> map = new HashMap<>();
        for (int i = 0; i < Math.min(keys.size(), values.size()); i++) {
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }
}
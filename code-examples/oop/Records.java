public class Records {
    // Record básico
    public record Point(int x, int y) {}
    
    // Record com validação
    public record Person(String name, int age) {
        // Construtor compacto com validação
        public Person {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
        }
        
        // Método adicional
        public boolean isAdult() {
            return age >= 18;
        }
    }
    
    // Record com campo derivado
    public record Rectangle(int width, int height) {
        // Campo derivado
        public int area() {
            return width * height;
        }
        
        // Método estático de fábrica
        public static Rectangle square(int side) {
            return new Rectangle(side, side);
        }
    }
    
    // Demonstração de uso
    public void demonstrateRecords() {
        Point point = new Point(10, 20);
        System.out.println("Point: " + point.x() + ", " + point.y());
        
        Person person = new Person("John", 25);
        System.out.println("Is adult? " + person.isAdult());
        
        Rectangle square = Rectangle.square(10);
        System.out.println("Square area: " + square.area());
    }
}
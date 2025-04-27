public class Polymorphism {
    // Interface para demonstrar polimorfismo
    public interface Shape {
        double calculateArea();
        double calculatePerimeter();
    }
    
    // Implementações concretas
    public class Circle implements Shape {
        private double radius;
        
        public Circle(double radius) {
            this.radius = radius;
        }
        
        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
        
        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }
    }
    
    public class Rectangle implements Shape {
        private double width;
        private double height;
        
        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }
        
        @Override
        public double calculateArea() {
            return width * height;
        }
        
        @Override
        public double calculatePerimeter() {
            return 2 * (width + height);
        }
    }
    
    // Demonstração de polimorfismo
    public void demonstratePolymorphism() {
        List<Shape> shapes = Arrays.asList(
            new Circle(5),
            new Rectangle(4, 6)
        );
        
        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.calculateArea());
            System.out.println("Perimeter: " + shape.calculatePerimeter());
        }
    }
}
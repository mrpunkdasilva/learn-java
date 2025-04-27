public class SealedClasses {
    // Classe sealed básica
    public sealed class Shape permits Circle, Rectangle, Triangle {
        protected String name;
        
        public Shape(String name) {
            this.name = name;
        }
        
        public abstract double area();
    }
    
    // Classes permitidas
    public final class Circle extends Shape {
        private double radius;
        
        public Circle(String name, double radius) {
            super(name);
            this.radius = radius;
        }
        
        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }
    
    public final class Rectangle extends Shape {
        private double width;
        private double height;
        
        public Rectangle(String name, double width, double height) {
            super(name);
            this.width = width;
            this.height = height;
        }
        
        @Override
        public double area() {
            return width * height;
        }
    }
    
    public final class Triangle extends Shape {
        private double base;
        private double height;
        
        public Triangle(String name, double base, double height) {
            super(name);
            this.base = base;
            this.height = height;
        }
        
        @Override
        public double area() {
            return (base * height) / 2;
        }
    }
    
    // Exemplo de uso com pattern matching
    public void demonstrateSealedClasses() {
        Shape shape = new Circle("circle1", 5);
        
        double area = switch (shape) {
            case Circle c -> Math.PI * c.radius * c.radius;
            case Rectangle r -> r.width * r.height;
            case Triangle t -> (t.base * t.height) / 2;
        };
        
        System.out.println("Area of " + shape.name + ": " + area);
    }
}
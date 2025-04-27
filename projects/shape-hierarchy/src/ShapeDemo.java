public class ShapeDemo {
    public static void main(String[] args) {
        // Create some shapes
        Circle circle = new Circle(new Point(0, 0), 5, "red");
        Rectangle rectangle = new Rectangle(new Point(2, 2), 4, 3, "blue");
        Triangle triangle = new Triangle(
            new Point(0, 0),
            new Point(3, 0),
            new Point(0, 4),
            "green"
        );

        // Create array of shapes
        Shape[] shapes = {circle, rectangle, triangle};

        // Display information about each shape
        System.out.println("Shape Information:");
        for (Shape shape : shapes) {
            System.out.println("\n" + shape);
            System.out.printf("Area: %.2f\n", shape.area());
            System.out.printf("Perimeter: %.2f\n", shape.perimeter());
        }

        // Test point containment
        Point testPoint = new Point(1, 1);
        System.out.println("\nTesting point " + testPoint);
        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() + 
                             " contains point: " + 
                             shape.contains(testPoint));
        }

        // Demonstrate movement
        System.out.println("\nMoving shapes:");
        for (Shape shape : shapes) {
            shape.move(1, 1);
            System.out.println("After moving: " + shape);
        }
    }
}
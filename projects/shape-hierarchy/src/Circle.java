public final class Circle extends Shape {
    private double radius;

    public Circle(Point center, double radius, String color) {
        super(center, color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean contains(Point point) {
        return getPosition().distanceTo(point) <= radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return super.toString() + " radius: " + radius;
    }
}
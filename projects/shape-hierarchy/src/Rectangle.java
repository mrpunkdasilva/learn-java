public final class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height, String color) {
        super(topLeft, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public boolean contains(Point point) {
        Point topLeft = getPosition();
        return point.x() >= topLeft.x() && 
               point.x() <= topLeft.x() + width &&
               point.y() >= topLeft.y() && 
               point.y() <= topLeft.y() + height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return super.toString() + 
               " width: " + width + 
               " height: " + height;
    }
}
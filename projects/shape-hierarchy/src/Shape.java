public sealed abstract class Shape permits Circle, Rectangle, Triangle {
    private Point position;
    private String color;

    public Shape(Point position, String color) {
        this.position = position;
        this.color = color;
    }

    public abstract double area();
    public abstract double perimeter();
    public abstract boolean contains(Point point);

    public Point getPosition() {
        return position;
    }

    public String getColor() {
        return color;
    }

    public void move(double dx, double dy) {
        position = new Point(position.x() + dx, position.y() + dy);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + 
               " at " + position + 
               " (color: " + color + ")";
    }
}
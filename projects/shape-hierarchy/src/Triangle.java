public final class Triangle extends Shape {
    private Point p2;
    private Point p3;

    public Triangle(Point p1, Point p2, Point p3, String color) {
        super(p1, color);
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public double area() {
        Point p1 = getPosition();
        // Using Heron's formula
        double a = p1.distanceTo(p2);
        double b = p2.distanceTo(p3);
        double c = p3.distanceTo(p1);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double perimeter() {
        Point p1 = getPosition();
        return p1.distanceTo(p2) + 
               p2.distanceTo(p3) + 
               p3.distanceTo(p1);
    }

    @Override
    public boolean contains(Point point) {
        // Using barycentric coordinates
        Point p1 = getPosition();
        double areaTotal = area();
        double area1 = new Triangle(point, p2, p3, "").area();
        double area2 = new Triangle(p1, point, p3, "").area();
        double area3 = new Triangle(p1, p2, point, "").area();
        
        return Math.abs(areaTotal - (area1 + area2 + area3)) < 0.0001;
    }

    @Override
    public String toString() {
        return super.toString() + 
               " p2: " + p2 + 
               " p3: " + p3;
    }
}
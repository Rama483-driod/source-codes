public class Circle extends Shape {
    private double radius;

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        if (radius <= 0) throw new InvalidShapeException("Radius must be positive.");
        this.radius = radius;
    }

    @Override public double getArea() { return Math.PI * radius * radius; }
    @Override public double getPerimeter() { return 2 * Math.PI * radius; }
    @Override public void resize(double f) {
        if (f <= 0) throw new InvalidShapeException("Factor must be positive.");
        radius *= f;
    }

    @Override
    public String toString() {
        return String.format("Circle[radius=%.2f | Circle[%s]]", radius, super.toString());
    }
}

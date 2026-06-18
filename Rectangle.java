public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        if (width <= 0 || height <= 0) throw new InvalidShapeException("Dimensions must be positive.");
        this.width = width;
        this.height = height;
    }

    @Override public double getArea() { return width * height; }
    @Override public double getPerimeter() { return 2 * (width + height); }
    @Override public void resize(double f) {
        if (f <= 0) throw new InvalidShapeException("Factor must be positive.");
        width *= f; height *= f;
    }

    @Override
    public String toString() {
        return String.format("Rectangle[width=%.2f | height=%.2f | Rectangle[%s]]", width, height, super.toString());
    }
}

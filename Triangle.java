public class Triangle extends Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c, String color, boolean filled) {
        super(color, filled);
        if (a <= 0 || b <= 0 || c <= 0) throw new InvalidShapeException("Sides must be positive.");
        if (a >= b+c || b >= a+c || c >= a+b) throw new InvalidShapeException("Triangle inequality violated.");
        this.a = a; this.b = b; this.c = c;
    }

    @Override public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    @Override public double getPerimeter() { return a + b + c; }
    @Override public void resize(double f) {
        if (f <= 0) throw new InvalidShapeException("Factor must be positive.");
        a *= f; b *= f; c *= f;
    }

    @Override
    public String toString() {
        return String.format("Triangle[a=%.2f | b=%.2f | c=%.2f | Triangle[%s]]", a, b, c, super.toString());
    }
}

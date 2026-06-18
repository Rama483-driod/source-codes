public abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void resize(double factor);

    @Override
    public String toString() {
        // Formats decimals to 2 decimal places automatically
        return String.format("color=%s | filled=%b | area=%.2f | perimeter=%.2f", 
            color, filled, getArea(), getPerimeter());
    }
}

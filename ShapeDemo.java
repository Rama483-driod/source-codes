public class ShapeDemo {
    public static void printAreas(Shape[] shapes) {
        for (int i = 0; i < shapes.length; i++) {
            Shape s = shapes[i];
            String className = s.getClass().getSimpleName();
            System.out.printf("%-12s area = %.2f\n", className, s.getArea());
        }
    }

    public static Shape largest(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) return null;
        Shape largestShape = shapes[0];
        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getArea() > largestShape.getArea()) {
                largestShape = shapes[i];
            }
        }
        return largestShape;
    }

    public static void main(String[] args) {
        // Initializing with sizes to match your sample test metrics
        Shape[] items = new Shape[3];
        items[0] = new Circle(5.0, "red", true);       // radius 5 gives area 78.54
        items[1] = new Rectangle(4.0, 6.0, "blue", false); // 4x6 gives area 24.00
        items[2] = new Triangle(3.0, 4.0, 5.0, "green", true); // 3-4-5 gives area 6.00

        // Output matching your target sequence layout
        printAreas(items);
        
        System.out.println();
        Shape top = largest(items);
        System.out.println("Largest: " + top);
    }
}

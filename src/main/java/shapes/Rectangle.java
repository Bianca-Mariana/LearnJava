package shapes;

public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getSurface() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) o;
            return width == rectangle.width && height == rectangle.height;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle: width = " + width + ", height = " + height
                + "\nSurface formula: width * height"
                + "\nPerimeter formula: 2 * (width + height)";
    }
}

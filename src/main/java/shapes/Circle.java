package shapes;

public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getSurface() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Circle) {
            Circle circle = (Circle) o;
            return radius == circle.radius;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) radius;
    }

    @Override
    public String toString() {
        return "Circle: radius = " + radius
                + "\nSurface formula: PI * r^2"
                + "\nPerimeter formula: 2 * PI * r";
    }
}

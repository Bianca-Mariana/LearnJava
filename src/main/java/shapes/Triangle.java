package shapes;

public class Triangle extends Shape {

    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getSurface() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Triangle) {
            Triangle triangle = (Triangle) o;
            return a == triangle.a && b == triangle.b && c == triangle.c;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) (a + b + c);
    }

    @Override
    public String toString() {
        return "Triangle: a = " + a + ", b = " + b + ", c = " + c
                + "\nSurface formula: sqrt(s * (s - a) * (s - b) * (s - c)), s = (a + b + c) / 2"
                + "\nPerimeter formula: a + b + c";
    }
}

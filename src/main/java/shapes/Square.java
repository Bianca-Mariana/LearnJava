package shapes;

public class Square extends Shape {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getSurface() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Square) {
            Square square = (Square) o;
            return side == square.side;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) side;
    }

    @Override
    public String toString() {
        return "Square: side = " + side
                + "\nSurface formula: side^2"
                + "\nPerimeter formula: 4 * side";
    }
}

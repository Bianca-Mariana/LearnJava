package shapes;
import java.util.ArrayList;
import java.util.List;

public class ShapeList {

    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        if (shapes.contains(shape)) {
            System.out.println("This shape already exists.");
        } else {
            shapes.add(shape);
        }
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public double getTotalSurface() {
        double total = 0;
        for (Shape shape : shapes) {
            total = total + shape.getSurface();
        }
        return total;
    }

    public double getTotalPerimeter() {
        double total = 0;
        for (Shape shape : shapes) {
            total = total+ shape.getPerimeter();
        }
        return total;
    }
}

package shapes;
public class Main {

    public static void main(String[] args) {
        ShapeList shapeList = new ShapeList();

        shapeList.addShape(new Rectangle(2, 3));
        shapeList.addShape(new Square(2));
        shapeList.addShape(new Circle(3));
        shapeList.addShape(new Triangle(2, 3, 4));
        shapeList.addShape(new Square(2));

        for (Shape shape : shapeList.getShapes()) {
            System.out.println(shape);
            System.out.println("Surface: " + String.format("%.2f", shape.getSurface()));
            System.out.println("Perimeter: " + String.format("%.2f", shape.getPerimeter()));
            System.out.println();
        }

        System.out.println("Total surface: " + String.format("%.2f", shapeList.getTotalSurface()));
        System.out.println("Total perimeter: " + String.format("%.2f", shapeList.getTotalPerimeter()));
    }
}

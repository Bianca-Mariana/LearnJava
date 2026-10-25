package shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeListTest {

    ShapeList shapeList = new ShapeList();

    @Test
    @DisplayName("Adds a single rectangle")
    public void testAddSingleRectangle() {
        shapeList.addShape(new Rectangle(4, 5));

        assertEquals(1, shapeList.getShapes().size());
        assertEquals(20, shapeList.getTotalSurface(), 0.001);
        assertEquals(18, shapeList.getTotalPerimeter(), 0.001);
    }

    @Test
    @DisplayName("Adds a single square")
    public void testAddSingleSquare() {
        shapeList.addShape(new Square(3));

        assertEquals(1, shapeList.getShapes().size());
        assertEquals(9, shapeList.getTotalSurface(), 0.001);
        assertEquals(12, shapeList.getTotalPerimeter(), 0.001);
    }

    @Test
    @DisplayName("Adds a single circle")
    public void testAddSingleCircle() {
        shapeList.addShape(new Circle(2));

        assertEquals(1, shapeList.getShapes().size());
        assertEquals(Math.PI * 4, shapeList.getTotalSurface(), 0.001);
        assertEquals(Math.PI * 4, shapeList.getTotalPerimeter(), 0.001);
    }

    @Test
    @DisplayName("Adds a single triangle")
    public void testAddSingleTriangle() {
        shapeList.addShape(new Triangle(3, 4, 5));

        assertEquals(1, shapeList.getShapes().size());
        assertEquals(6, shapeList.getTotalSurface(), 0.001);
        assertEquals(12, shapeList.getTotalPerimeter(), 0.001);
    }

    @Test
    @DisplayName("Adds all types of shapes and calculates the totals")
    public void testAddAllTypesOfShapes() {
        shapeList.addShape(new Rectangle(4, 5));
        shapeList.addShape(new Square(3));
        shapeList.addShape(new Circle(2));
        shapeList.addShape(new Triangle(3, 4, 5));

        assertEquals(4, shapeList.getShapes().size());
        assertEquals(20 + 9 + Math.PI * 4 + 6, shapeList.getTotalSurface(), 0.001);
        assertEquals(18 + 12 + Math.PI * 4 + 12, shapeList.getTotalPerimeter(), 0.001);
    }

    @Test
    @DisplayName("A pair of different shapes of the same type can be added")
    public void testAddPairOfSameType() {
        shapeList.addShape(new Rectangle(4, 5));
        shapeList.addShape(new Rectangle(2, 3));

        assertEquals(2, shapeList.getShapes().size());
        assertEquals(26, shapeList.getTotalSurface(), 0.001);
        assertEquals(28, shapeList.getTotalPerimeter(), 0.001);
    }

    @Test
    @DisplayName("A pair of shapes of different types can be added")
    public void testAddPairOfDifferentTypes() {
        shapeList.addShape(new Square(2));
        shapeList.addShape(new Triangle(3, 4, 5));

        assertEquals(2, shapeList.getShapes().size());
        assertEquals(10, shapeList.getTotalSurface(), 0.001);
        assertEquals(20, shapeList.getTotalPerimeter(), 0.001);
    }

    @Test
    @DisplayName("A duplicate shape is not added")
    public void testAddDuplicate() {
        shapeList.addShape(new Circle(1));
        shapeList.addShape(new Circle(1));

        assertEquals(1, shapeList.getShapes().size());
        assertEquals(Math.PI, shapeList.getTotalSurface(), 0.001);
        assertEquals(2 * Math.PI, shapeList.getTotalPerimeter(), 0.001);
    }

    @Test
    @DisplayName("Duplicates of every type are not added")
    public void testAddDuplicatesOfAllTypes() {
        shapeList.addShape(new Rectangle(4, 5));
        shapeList.addShape(new Square(3));
        shapeList.addShape(new Circle(2));
        shapeList.addShape(new Triangle(3, 4, 5));

        shapeList.addShape(new Rectangle(4, 5));
        shapeList.addShape(new Square(3));
        shapeList.addShape(new Circle(2));
        shapeList.addShape(new Triangle(3, 4, 5));

        assertEquals(4, shapeList.getShapes().size());
    }

    @Test
    @DisplayName("A square and a rectangle with the same sides are not duplicates")
    public void testSquareAndRectangleAreDifferent() {
        shapeList.addShape(new Square(4));
        shapeList.addShape(new Rectangle(4, 4));

        assertEquals(2, shapeList.getShapes().size());
    }
}

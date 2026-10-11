package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class DistanceCalculatorTest {

    DistanceCalculator calculator = new DistanceCalculator();

    @Test
    public void testExampleFromHomework() {
        System.out.println("Test 1: testExampleFromHomework");
        System.out.println("Description: checks the example given in the homework");
        checkResult("10 cm + 1 m - 10 mm", Unit.MM, 1090);
    }

    @Test
    public void testResultInCentimeters() {
        System.out.println("Test 2: testResultInCentimeters");
        System.out.println("Description: checks the same expression with the result in centimeters");
        checkResult("10 cm + 1 m - 10 mm", Unit.CM, 109);
    }

    @Test
    public void testSubtraction() {
        System.out.println("Test 3: testSubtraction");
        System.out.println("Description: checks subtraction between different units");
        checkResult("2 km - 500 m", Unit.M, 1500);
    }

    @Test
    public void testNegativeResult() {
        System.out.println("Test 4: testNegativeResult");
        System.out.println("Description: checks that the result can be negative");
        checkResult("1 m - 3 m", Unit.M, -2);
    }

    @Test
    public void testResultWithDecimals() {
        System.out.println("Test 5: testResultWithDecimals");
        System.out.println("Description: checks that the result can have decimals");
        checkResult("5 mm", Unit.CM, 0.5);
    }

    @Test
    public void testWrongOperator() {
        System.out.println("Test 6: testWrongOperator");
        System.out.println("Description: checks that only + and - are allowed");
        checkError("2 m * 3 m", Unit.M);
    }

    @Test
    public void testWrongUnit() {
        System.out.println("Test 7: testWrongUnit");
        System.out.println("Description: checks that an unknown unit is not allowed");
        checkError("2 inch + 3 cm", Unit.CM);
    }

    private void checkResult(String expression, Unit unit, double expected) {
        double actual = calculator.calculate(expression, unit);

        System.out.println("Expression:  " + expression);
        System.out.println("Unit:        " + unit);
        System.out.println("Expected:    " + expected);
        System.out.println("Actual:      " + actual);
        System.out.println();

        assertEquals(expected, actual);
    }

    private void checkError(String expression, Unit unit) {
        try {
            calculator.calculate(expression, unit);
            fail("An error was expected");
        } catch (IllegalArgumentException e) {
            System.out.println("Expression:  " + expression);
            System.out.println("Unit:        " + unit);
            System.out.println("Error:       " + e.getMessage());
            System.out.println();
        }
    }
}

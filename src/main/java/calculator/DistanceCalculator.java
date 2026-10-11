package calculator;

import java.util.Scanner;

public class DistanceCalculator {

    public double calculate(String expression, Unit outputUnit) {
        Scanner scanner = new Scanner(expression);

        double result = toMillimeters(scanner.next(), scanner.next());

        while (scanner.hasNext()) {
            String operator = scanner.next();
            double number = toMillimeters(scanner.next(), scanner.next());

            if (operator.equals("+")) {
                result = result + number;
            } else if (operator.equals("-")) {
                result = result - number;
            } else {
                throw new IllegalArgumentException("Wrong operator: " + operator);
            }
        }

        scanner.close();
        return result / outputUnit.getMillimeters();
    }

    private double toMillimeters(String number, String unitText) {
        double value = Double.parseDouble(number);
        Unit unit = Unit.fromText(unitText);
        return value * unit.getMillimeters();
    }
}

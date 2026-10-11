package calculator;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DistanceCalculator calculator = new DistanceCalculator();

        System.out.println("Write the expression with a space between every number, unit and sign.");
        System.out.println("Example: 10 cm + 1 m - 10 mm");

        boolean done = false;

        while (!done) {
            System.out.print("Enter the expression: ");
            String expression = scanner.nextLine();

            System.out.print("Enter the output unit (mm, cm, dm, m, km): ");
            String unitText = scanner.nextLine();

            try {
                Unit outputUnit = Unit.fromText(unitText);
                double result = calculator.calculate(expression, outputUnit);
                System.out.println(expression + " = " + result + " " + unitText);
                done = true;
            } catch (NoSuchElementException e) {
                System.out.println("Error: Write a space between every number, unit and sign.");
                System.out.println("Please try again.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }

        scanner.close();
    }
}

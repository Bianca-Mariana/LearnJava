package birthdays;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please write 3 things, with a space between them:");
            System.out.println("  1. the file to read            (for example: persons.txt)");
            System.out.println("  2. the month, from 1 to 12     (for example: 3)");
            System.out.println("  3. the file to save the result (for example: result.txt)");
            return;
        }

        String inputFile = args[0];
        int month = Integer.parseInt(args[1]);
        String outputFile = args[2];

        BirthdayFilter birthdayFilter = new BirthdayFilter();
        try {
            birthdayFilter.run(inputFile, month, outputFile);
            System.out.println("Done! Result written to " + outputFile);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not read or write the file: " + e.getMessage());
        }
    }
}

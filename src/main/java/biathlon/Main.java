package biathlon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CsvParser parser = new CsvParser();
        StandingsCalculator calculator = new StandingsCalculator();

        try {
            String text = Files.readString(Path.of("athletes.csv"));
            List<Athlete> athletes = parser.parse(text);

            for (String line : calculator.getPodium(athletes)) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: could not read the file athletes.csv");
        }
    }
}

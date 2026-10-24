package biathlon;

import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public List<Athlete> parse(String csvText) {
        List<Athlete> athletes = new ArrayList<>();
        String[] lines = csvText.split("\n");

        for (String line : lines) {
            if (!line.isBlank()) {
                athletes.add(parseLine(line.trim()));
            }
        }

        return athletes;
    }

    private Athlete parseLine(String line) {
        String[] columns = line.split(",");

        int number = Integer.parseInt(columns[0]);
        String name = columns[1];
        String countryCode = columns[2];

        String[] time = columns[3].split(":");
        int skiTimeSeconds = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

        String[] shootingRanges = {columns[4], columns[5], columns[6]};

        return new Athlete(number, name, countryCode, skiTimeSeconds, shootingRanges);
    }
}

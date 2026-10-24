package biathlon;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvParserTest {

    CsvParser parser = new CsvParser();

    @Test
    @DisplayName("Reads all the athletes from the CSV")
    public void testReadAllAthletes() {
        String csv = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n"
                + "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n"
                + "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx\n";

        List<Athlete> athletes = parser.parse(csv);

        assertEquals(3, athletes.size());
    }

    @Test
    @DisplayName("Reads every column of a line")
    public void testReadColumns() {
        String csv = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";

        Athlete athlete = parser.parse(csv).get(0);

        assertEquals(11, athlete.getNumber());
        assertEquals("Umar Jorgson", athlete.getName());
        assertEquals("SK", athlete.getCountryCode());
        assertEquals(30 * 60 + 27, athlete.getSkiTimeSeconds());
        assertEquals(30, athlete.getPenaltySeconds());
    }

    @Test
    @DisplayName("Empty lines are skipped")
    public void testEmptyLines() {
        String csv = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n"
                + "\n"
                + "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n";

        List<Athlete> athletes = parser.parse(csv);

        assertEquals(2, athletes.size());
    }
}

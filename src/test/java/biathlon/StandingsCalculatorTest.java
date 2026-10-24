package biathlon;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandingsCalculatorTest {

    CsvParser parser = new CsvParser();
    StandingsCalculator calculator = new StandingsCalculator();

    @Test
    @DisplayName("Checks the example given in the homework")
    public void testExampleFromHomework() {
        String csv = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n"
                + "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n"
                + "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx\n";

        List<String> podium = calculator.getPodium(parser.parse(csv));

        assertEquals("Winner - Piotr Smitzer 30:10 (30:10 + 0)", podium.get(0));
        assertEquals("Runner-up - Jimmy Smiles 30:15 (29:15 + 60)", podium.get(1));
        assertEquals("Third Place - Umar Jorgson 30:57 (30:27 + 30)", podium.get(2));
    }

    @Test
    @DisplayName("The fastest skier can lose because of the penalties")
    public void testPenaltyChangesTheOrder() {
        String csv = "1,Fast Skier,RO,28:00,ooooo,xxxxx,xxxxx\n"
                + "2,Good Shooter,BG,28:30,xxxxx,xxxxx,xxxxx\n";

        List<String> podium = calculator.getPodium(parser.parse(csv));

        assertEquals("Winner - Good Shooter 28:30 (28:30 + 0)", podium.get(0));
        assertEquals("Runner-up - Fast Skier 28:50 (28:00 + 50)", podium.get(1));
    }

    @Test
    @DisplayName("Only the first 3 athletes are on the podium")
    public void testOnlyThreeOnPodium() {
        String csv = "1,A One,RO,30:00,xxxxx,xxxxx,xxxxx\n"
                + "2,B Two,RO,31:00,xxxxx,xxxxx,xxxxx\n"
                + "3,C Three,RO,29:00,xxxxx,xxxxx,xxxxx\n"
                + "4,D Four,RO,32:00,xxxxx,xxxxx,xxxxx\n";

        List<String> podium = calculator.getPodium(parser.parse(csv));

        assertEquals(3, podium.size());
        assertEquals("Winner - C Three 29:00 (29:00 + 0)", podium.get(0));
    }
}

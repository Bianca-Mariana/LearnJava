package birthdays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BirthdayFilterTest {

    private BirthdayFilter birthdayFilter;
    private List<Person> persons;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        birthdayFilter = new BirthdayFilter();
        persons = List.of(
                new Person("Alina", "Vlad", LocalDate.of(1992, 3, 12)),
                new Person("Nae", "Gabriela", LocalDate.of(1987, 7, 30)),
                new Person("Alex", "Danescu", LocalDate.of(1999, 3, 5)),
                new Person("Cristian", "Vlase", LocalDate.of(1984, 3, 21))
        );
    }

    @Test
    void readPersonsReadsEveryLineFromFile() throws IOException {
        Path inputFile = tempDir.resolve("input.txt");
        Files.write(inputFile, List.of("Alina,Vlad,1992-03-12", "Nae,Gabriela,1987-07-30"));

        List<Person> result = birthdayFilter.readPersons(inputFile.toString());

        assertEquals(2, result.size());
        assertEquals("Alina", result.get(0).getFirstName());
        assertEquals("Vlad", result.get(0).getLastName());
        assertEquals(LocalDate.of(1992, 3, 12), result.get(0).getDateOfBirth());
        assertEquals("Nae", result.get(1).getFirstName());
    }

    @Test
    void getNamesBornInMonthKeepsOnlyPersonsFromThatMonth() {
        List<String> result = birthdayFilter.getNamesBornInMonth(persons, 7);

        assertEquals(List.of("Nae,Gabriela"), result);
    }

    @Test
    void getNamesBornInMonthReturnsNamesSortedAlphabetically() {
        List<String> result = birthdayFilter.getNamesBornInMonth(persons, 3);

        assertEquals(List.of("Alex,Danescu", "Alina,Vlad", "Cristian,Vlase"), result);
    }

    @Test
    void getNamesBornInMonthReturnsEmptyListWhenNobodyMatches() {
        List<String> result = birthdayFilter.getNamesBornInMonth(persons, 1);

        assertTrue(result.isEmpty());
    }

    @Test
    void getNamesBornInMonthThrowsExceptionForInvalidMonth() {
        assertThrows(IllegalArgumentException.class, () -> birthdayFilter.getNamesBornInMonth(persons, 0));
        assertThrows(IllegalArgumentException.class, () -> birthdayFilter.getNamesBornInMonth(persons, 13));
    }

    @Test
    void runWritesSortedNamesToOutputFile() throws IOException {
        Path inputFile = tempDir.resolve("input.txt");
        Path outputFile = tempDir.resolve("output.txt");
        Files.write(inputFile, List.of(
                "Alina,Vlad,1992-03-12",
                "Nae,Gabriela,1987-07-30",
                "Alex,Danescu,1999-03-05"
        ));

        birthdayFilter.run(inputFile.toString(), 3, outputFile.toString());

        List<String> lines = Files.readAllLines(outputFile);
        assertEquals(List.of("Alex,Danescu", "Alina,Vlad"), lines);
    }
}

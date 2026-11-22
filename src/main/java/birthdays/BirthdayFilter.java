package birthdays;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class BirthdayFilter {

    public List<Person> readPersons(String inputFile) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(inputFile));

        return lines.stream()
                .map(line -> parsePerson(line))
                .toList();
    }

    private Person parsePerson(String line) {
        String[] parts = line.split(",");
        String firstName = parts[0];
        String lastName = parts[1];
        LocalDate dateOfBirth = LocalDate.parse(parts[2]);
        return new Person(firstName, lastName, dateOfBirth);
    }

    public List<String> getNamesBornInMonth(List<Person> persons, int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12, but was " + month);
        }

        return persons.stream()
                .filter(person -> {
                    int birthMonth = person.getDateOfBirth().getMonthValue();
                    if (birthMonth == month) {
                        return true;
                    } else {
                        return false;
                    }
                })
                .map(person -> {
                    String name = person.getFirstName() + "," + person.getLastName();
                    return name;
                })
                .sorted()
                .toList();
    }

    public void writeNames(List<String> names, String outputFile) throws IOException {
        Files.write(Path.of(outputFile), names);
    }

    public void run(String inputFile, int month, String outputFile) throws IOException {
        List<Person> persons = readPersons(inputFile);
        List<String> names = getNamesBornInMonth(persons, month);
        writeNames(names, outputFile);
    }
}

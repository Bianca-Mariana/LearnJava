package students;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentTest {

    @Test
    @DisplayName("Creates a valid student")
    public void testCreateValidStudent() throws InvalidInputException {
        Student student = new Student("Ana", "Radu", LocalDate.of(2001, 3, 4), "f", "S1");

        assertEquals("Ana", student.getFirstName());
        assertEquals("Radu", student.getLastName());
        assertEquals(LocalDate.of(2001, 3, 4), student.getDateOfBirth());
        assertEquals(Gender.FEMALE, student.getGender());
        assertEquals("S1", student.getId());
    }

    @Test
    @DisplayName("Accepts gender in upper and lower case")
    public void testGenderUpperAndLowerCase() throws InvalidInputException {
        assertEquals(Gender.MALE, new Student("Dan", "Radu", LocalDate.of(1999, 3, 2), "m", "S2").getGender());
        assertEquals(Gender.MALE, new Student("Dan", "Radu", LocalDate.of(1999, 3, 2), "MALE", "S2").getGender());
        assertEquals(Gender.FEMALE, new Student("Ana", "Radu", LocalDate.of(2001, 3, 4), "F", "S1").getGender());
        assertEquals(Gender.FEMALE, new Student("Ana", "Radu", LocalDate.of(2001, 3, 4), "Female", "S1").getGender());
    }

    @Test
    @DisplayName("Throws when the gender is invalid")
    public void testInvalidGender() {
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> new Student("Ana", "Radu", LocalDate.of(2001, 3, 4), "x", "S1"));

        assertEquals("Invalid gender: x (expected M, F, male or female)", exception.getMessage());
    }

    @Test
    @DisplayName("Throws when the gender is empty")
    public void testEmptyGender() {
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> new Student("Ana", "Radu", LocalDate.of(2001, 3, 4), "", "S1"));

        assertEquals("Gender must not be empty", exception.getMessage());
    }

    @Test
    @DisplayName("Throws when the first name is empty")
    public void testEmptyFirstName() {
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> new Student("  ", "Radu", LocalDate.of(2001, 3, 4), "f", "S1"));

        assertEquals("First name must not be empty", exception.getMessage());
    }

    @Test
    @DisplayName("Throws when the last name is empty")
    public void testEmptyLastName() {
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> new Student("Ana", "", LocalDate.of(2001, 3, 4), "f", "S1"));

        assertEquals("Last name must not be empty", exception.getMessage());
    }

    @Test
    @DisplayName("Throws when the date of birth is missing")
    public void testMissingDateOfBirth() {
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> new Student("Ana", "Radu", null, "f", "S1"));

        assertEquals("Date of birth must not be empty", exception.getMessage());
    }

    @Test
    @DisplayName("Throws when the year of birth is before 1900")
    public void testYearOfBirthBefore1900() {
        assertThrows(InvalidInputException.class,
                () -> new Student("Ana", "Radu", LocalDate.of(1899, 12, 31), "f", "S1"));
    }

    @Test
    @DisplayName("Throws when the student is younger than current year - 18")
    public void testYearOfBirthTooRecent() {
        int tooRecentYear = LocalDate.now().getYear() - 17;

        assertThrows(InvalidInputException.class,
                () -> new Student("Ana", "Radu", LocalDate.of(tooRecentYear, 1, 1), "f", "S1"));
    }

    @Test
    @DisplayName("Accepts the limit years 1900 and current year - 18")
    public void testYearOfBirthLimits() throws InvalidInputException {
        int maxYear = LocalDate.now().getYear() - 18;

        new Student("Ana", "Radu", LocalDate.of(1900, 1, 1), "f", "S1");
        new Student("Dan", "Radu", LocalDate.of(maxYear, 12, 31), "m", "S2");
    }

    @Test
    @DisplayName("Calculates the age from the date of birth")
    public void testAgeIsCalculated() throws InvalidInputException {
        LocalDate today = LocalDate.now();
        Student hadBirthdayToday = new Student("Ana", "Radu", today.minusYears(25), "f", "S1");
        Student birthdayTomorrow = new Student("Dan", "Radu", today.minusYears(25).plusDays(1), "m", "S2");

        assertEquals(25, hadBirthdayToday.getAge());
        assertEquals(24, birthdayTomorrow.getAge());
    }

    @Test
    @DisplayName("Shows the student as [ID] LastName FirstName, gender, date")
    public void testToString() throws InvalidInputException {
        Student student = new Student("Ana", "Radu", LocalDate.of(2001, 3, 4), "f", "S1");

        assertEquals("[S1] Radu Ana, F, 04.03.2001", student.toString());
    }
}

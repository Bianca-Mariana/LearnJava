package students;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentRepositoryTest {

    StudentRepository repository = new StudentRepository();

    @BeforeEach
    public void addStudents() throws InvalidInputException {
        repository.addStudent(new Student("Ana", "Radu", LocalDate.of(2001, 3, 4), "f", "S1"));
        repository.addStudent(new Student("Dan", "Radu", LocalDate.of(1999, 3, 2), "m", "S2"));
        repository.addStudent(new Student("Cristian", "Vlase", LocalDate.of(2000, 3, 3), "M", "S3"));
        repository.addStudent(new Student("Andreea", "Zamfir", LocalDate.of(1998, 3, 1), "F", "S4"));
    }

    @Test
    @DisplayName("Adds a student")
    public void testAddStudent() throws InvalidInputException {
        repository.addStudent(new Student("Ioana", "Popa", LocalDate.of(2002, 5, 10), "f", "S5"));

        assertEquals(5, repository.getAllStudents().size());
    }

    @Test
    @DisplayName("Throws when adding a null student")
    public void testAddNullStudent() {
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> repository.addStudent(null));

        assertEquals("Student must not be null", exception.getMessage());
    }

    @Test
    @DisplayName("Throws when adding a student with an existing ID")
    public void testAddDuplicateId() {
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> repository.addStudent(new Student("Ioana", "Popa", LocalDate.of(2002, 5, 10), "f", "S1")));

        assertEquals("A student with ID S1 already exists", exception.getMessage());
        assertEquals(4, repository.getAllStudents().size());
    }

    @Test
    @DisplayName("Removes a student by ID")
    public void testRemoveStudent() throws InvalidInputException {
        repository.removeStudent("S2");

        assertEquals(3, repository.getAllStudents().size());
    }

    @Test
    @DisplayName("Throws when removing with an empty ID")
    public void testRemoveEmptyId() {
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> repository.removeStudent(""));

        assertEquals("ID must not be empty", exception.getMessage());
    }

    @Test
    @DisplayName("Throws when removing a student that does not exist")
    public void testRemoveMissingStudent() {
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> repository.removeStudent("S9"));

        assertEquals("No student with ID S9", exception.getMessage());
        assertEquals(4, repository.getAllStudents().size());
    }

    @Test
    @DisplayName("Finds the students with a given age")
    public void testFindByAge() throws InvalidInputException {
        LocalDate today = LocalDate.now();
        repository.addStudent(new Student("Ioana", "Popa", today.minusYears(30), "f", "S5"));
        repository.addStudent(new Student("Mihai", "Popa", today.minusYears(30).minusMonths(2), "m", "S6"));

        List<Student> result = repository.findByAge("30");

        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Returns an empty list when nobody has the given age")
    public void testFindByAgeNoResult() throws InvalidInputException {
        assertTrue(repository.findByAge("80").isEmpty());
    }

    @Test
    @DisplayName("Throws when the age is not a number")
    public void testFindByAgeNotANumber() {
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> repository.findByAge("abc"));

        assertEquals("Age is not a number: abc", exception.getMessage());
    }

    @Test
    @DisplayName("Throws when the age is negative")
    public void testFindByAgeNegative() {
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> repository.findByAge("-3"));

        assertEquals("Age must not be negative: -3", exception.getMessage());
    }

    @Test
    @DisplayName("Throws when the age is empty")
    public void testFindByAgeEmpty() {
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> repository.findByAge(""));

        assertEquals("Age must not be empty", exception.getMessage());
    }

    @Test
    @DisplayName("Lists the students ordered by last name, then first name")
    public void testOrderByLastName() throws InvalidInputException {
        List<Student> result = repository.getStudentsOrderedBy("lastName");

        assertEquals("S1", result.get(0).getId());
        assertEquals("S2", result.get(1).getId());
        assertEquals("S3", result.get(2).getId());
        assertEquals("S4", result.get(3).getId());
    }

    @Test
    @DisplayName("Lists the students ordered by birth date")
    public void testOrderByBirthDate() throws InvalidInputException {
        List<Student> result = repository.getStudentsOrderedBy("birthDate");

        assertEquals("S4", result.get(0).getId());
        assertEquals("S2", result.get(1).getId());
        assertEquals("S3", result.get(2).getId());
        assertEquals("S1", result.get(3).getId());
    }

    @Test
    @DisplayName("Throws when the sort criterion is empty")
    public void testOrderByEmptyCriterion() {
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> repository.getStudentsOrderedBy(""));

        assertEquals("Sort criterion must not be empty", exception.getMessage());
    }

    @Test
    @DisplayName("Throws when the sort criterion is unknown")
    public void testOrderByUnknownCriterion() {
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> repository.getStudentsOrderedBy("age"));

        assertEquals("Unknown sort criterion: age (expected lastName or birthDate)", exception.getMessage());
    }
}

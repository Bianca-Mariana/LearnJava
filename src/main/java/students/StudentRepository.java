package students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class StudentRepository {

    private static final Logger LOGGER = Logger.getLogger(StudentRepository.class.getName());

    private final Map<String, Student> students = new HashMap<>();

    public void addStudent(Student student) throws InvalidInputException {
        if (student == null) {
            String message = "Student must not be null";
            LOGGER.warning(message);
            throw new InvalidInputException(message);
        }
        if (students.containsKey(student.getId())) {
            String message = "A student with ID " + student.getId() + " already exists";
            LOGGER.warning(message);
            throw new InvalidInputException(message);
        }

        students.put(student.getId(), student);
        LOGGER.info("Student added: " + student);
    }

    public void removeStudent(String id) throws InvalidInputException {
        if (id == null || id.isBlank()) {
            String message = "ID must not be empty";
            LOGGER.warning(message);
            throw new InvalidInputException(message);
        }
        if (!students.containsKey(id)) {
            String message = "No student with ID " + id;
            LOGGER.warning(message);
            throw new InvalidInputException(message);
        }

        Student removed = students.remove(id);
        LOGGER.info("Student removed: " + removed);
    }

    public List<Student> findByAge(String age) throws InvalidInputException {
        if (age == null || age.isBlank()) {
            String message = "Age must not be empty";
            LOGGER.warning(message);
            throw new InvalidInputException(message);
        }

        int ageValue;
        try {
            ageValue = Integer.parseInt(age.trim());
        } catch (NumberFormatException e) {
            String message = "Age is not a number: " + age;
            LOGGER.warning(message);
            throw new InvalidInputException(message);
        }

        if (ageValue < 0) {
            String message = "Age must not be negative: " + ageValue;
            LOGGER.warning(message);
            throw new InvalidInputException(message);
        }

        List<Student> result = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getAge() == ageValue) {
                result.add(student);
            }
        }
        LOGGER.info("Students with age " + ageValue + ": " + result.size());
        return result;
    }

    public List<Student> getStudentsOrderedBy(String criterion) throws InvalidInputException {
        if (criterion == null || criterion.isBlank()) {
            String message = "Sort criterion must not be empty";
            LOGGER.warning(message);
            throw new InvalidInputException(message);
        }

        Comparator<Student> comparator;
        String value = criterion.trim();
        if (value.equalsIgnoreCase("lastName")) {
            comparator = Comparator.comparing(Student::getLastName)
                    .thenComparing(Student::getFirstName);
        } else if (value.equalsIgnoreCase("birthDate")) {
            comparator = Comparator.comparing(Student::getDateOfBirth);
        } else {
            String message = "Unknown sort criterion: " + criterion + " (expected lastName or birthDate)";
            LOGGER.warning(message);
            throw new InvalidInputException(message);
        }

        List<Student> result = new ArrayList<>(students.values());
        result.sort(comparator);
        LOGGER.info("Students sorted by " + value + ": " + result.size());
        return result;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }
}

package students;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();

        System.out.println("Adding students:");
        try {
            repository.addStudent(new Student("Ana", "Radu", LocalDate.of(2001, 3, 4), "f", "S1"));
            repository.addStudent(new Student("Dan", "Radu", LocalDate.of(1999, 3, 2), "M", "S2"));
            repository.addStudent(new Student("Cristian", "Vlase", LocalDate.of(2000, 3, 3), "male", "S3"));
            repository.addStudent(new Student("Andreea", "Zamfir", LocalDate.of(1998, 3, 1), "FEMALE", "S4"));
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
        printStudents(repository.getAllStudents());

        System.out.println("Sorted by last name:");
        try {
            printStudents(repository.getStudentsOrderedBy("lastName"));
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Sorted by birth date:");
        try {
            printStudents(repository.getStudentsOrderedBy("birthDate"));
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Students aged 26:");
        try {
            printStudents(repository.findByAge("26"));
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Removing student S2:");
        try {
            repository.removeStudent("S2");
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
        printStudents(repository.getAllStudents());

        System.out.println("Errors:");
        try {
            new Student("", "Popa", LocalDate.of(2000, 1, 1), "f", "S5");
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            new Student("Ioana", "Popa", LocalDate.of(2010, 1, 1), "f", "S5");
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            new Student("Ioana", "Popa", LocalDate.of(2000, 1, 1), "x", "S5");
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            repository.removeStudent("S9");
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            repository.findByAge("abc");
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            repository.findByAge("-3");
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            repository.getStudentsOrderedBy("");
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println("   " + student);
        }
    }
}

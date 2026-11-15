package students;

import java.time.LocalDate;
import java.time.Period;
public class Student {

    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final Gender gender;
    private final String id;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, String id)
            throws InvalidInputException {
        if (firstName == null || firstName.isBlank()) {
            throw new InvalidInputException("First name must not be empty");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new InvalidInputException("Last name must not be empty");
        }
        if (dateOfBirth == null) {
            throw new InvalidInputException("Date of birth must not be empty");
        }
        int maxYear = LocalDate.now().getYear() - 18;
        if (dateOfBirth.getYear() < 1900 || dateOfBirth.getYear() > maxYear) {
            throw new InvalidInputException(
                    "Year of birth must be between 1900 and " + maxYear + ", but was " + dateOfBirth.getYear());
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = Gender.fromString(gender);
        this.id = id;
    }

    public String getFirstName() {


        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public Gender getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        String genderLetter;
        if (gender == Gender.MALE) {
            genderLetter = "M";
        } else {
            genderLetter = "F";
        }

        String day = String.valueOf(dateOfBirth.getDayOfMonth());
        if (day.length() == 1) {
            day = "0" + day;
        }
        String month = String.valueOf(dateOfBirth.getMonthValue());
        if (month.length() == 1) {
            month = "0" + month;
        }
        int year = dateOfBirth.getYear();

        return "[" + id + "] " + lastName + " " + firstName + ", " + genderLetter + ", " + day + "." + month + "." + year;
    }
}

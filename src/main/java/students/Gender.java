package students;

public enum Gender {
    MALE,
    FEMALE;

    public static Gender fromString(String text) throws InvalidInputException {
        if (text == null || text.isBlank()) {
            throw new InvalidInputException("Gender must not be empty");
        }

        String value = text.trim();
        if (value.equalsIgnoreCase("M") || value.equalsIgnoreCase("MALE")) {
            return MALE;
        }
        if (value.equalsIgnoreCase("F") || value.equalsIgnoreCase("FEMALE")) {
            return FEMALE;
        }
        throw new InvalidInputException("Invalid gender: " + text + " (expected M, F, male or female)");
    }
}

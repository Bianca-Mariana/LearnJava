package calculator;

public enum Unit {
    MM(1),
    CM(10),
    DM(100),
    M(1000),
    KM(1000000);

    private final int millimeters;

    Unit(int millimeters) {

        this.millimeters = millimeters;
    }

    public int getMillimeters() {

        return millimeters;
    }

    public static Unit fromText(String text) {
        if (text.equals("+") || text.equals("-")) {
            throw new IllegalArgumentException("A number has no unit. Every number needs a unit: mm, cm, dm, m or km");
        }

        try {
            return Unit.valueOf(text.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Wrong unit: " + text + ". Allowed units: mm, cm, dm, m or km");
        }
    }
}


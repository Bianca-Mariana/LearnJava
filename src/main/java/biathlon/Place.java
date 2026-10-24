package biathlon;

public enum Place {
    WINNER("Winner"),
    RUNNER_UP("Runner-up"),
    THIRD_PLACE("Third Place");

    private final String text;

    Place(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

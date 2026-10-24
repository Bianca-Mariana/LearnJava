package biathlon;

public class Athlete {

    private int number;
    private String name;
    private String countryCode;
    private int skiTimeSeconds;
    private String[] shootingRanges;

    public Athlete(int number, String name, String countryCode, int skiTimeSeconds, String[] shootingRanges) {
        this.number = number;
        this.name = name;
        this.countryCode = countryCode;
        this.skiTimeSeconds = skiTimeSeconds;
        this.shootingRanges = shootingRanges;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getSkiTimeSeconds() {
        return skiTimeSeconds;
    }

    public int getPenaltySeconds() {
        int missedShots = 0;
        for (String range : shootingRanges) {
            for (char shot : range.toCharArray()) {
                if (shot == 'o') {
                    missedShots++;
                }
            }
        }
        return missedShots * 10;
    }

    public int getFinalTimeSeconds() {
        return skiTimeSeconds + getPenaltySeconds();
    }

    @Override
    public String toString() {
        return name + " " + formatTime(getFinalTimeSeconds())
                + " (" + formatTime(skiTimeSeconds) + " + " + getPenaltySeconds() + ")";
    }

    private String formatTime(int seconds) {
        return String.format("%d:%02d", seconds / 60, seconds % 60);
    }
}

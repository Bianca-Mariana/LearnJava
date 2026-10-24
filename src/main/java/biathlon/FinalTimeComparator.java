package biathlon;

import java.util.Comparator;

public class FinalTimeComparator implements Comparator<Athlete> {

    @Override
    public int compare(Athlete a1, Athlete a2) {

        return a1.getFinalTimeSeconds() - a2.getFinalTimeSeconds();
    }
}

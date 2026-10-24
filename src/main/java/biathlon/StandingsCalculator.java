package biathlon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StandingsCalculator {

    public List<String> getPodium(List<Athlete> athletes) {
        List<Athlete> sorted = new ArrayList<>(athletes);
        Collections.sort(sorted, new FinalTimeComparator());

        List<String> podium = new ArrayList<>();
        Place[] places = Place.values();
        for (int i = 0; i < places.length && i < sorted.size(); i++) {
            podium.add(places[i].getText() + " - " + sorted.get(i));
        }

        return podium;
    }
}

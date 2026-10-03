package comparators;
import models.Person;
import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {

        return p1.getName().compareToIgnoreCase(p2.getName());
    }
}

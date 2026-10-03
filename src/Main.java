import comparators.PersonAgeComparator;
import comparators.PersonNameComparator;
import models.Address;
import models.Country;
import models.Hired;
import models.Hobby;
import models.Person;
import models.Student;
import models.Unemployed;
import service.PersonService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        PersonService service = new PersonService();

        Person raluca = new Student("Raluca", 24, "UPB");
        Person sorin = new Hired("Sorin", 41, "Telekom");
        Person timea = new Unemployed("Timea", 19);

        List<Person> persons = new ArrayList<>();
        persons.add(raluca);
        persons.add(sorin);
        persons.add(timea);

        Set<Person> byName = new TreeSet<>(new PersonNameComparator());
        byName.addAll(persons);
        System.out.println("Sorted by name:");
        service.printPersons(byName);
        System.out.println();

        Set<Person> byAge = new TreeSet<>(new PersonAgeComparator());
        byAge.addAll(persons);
        System.out.println("Sorted by age:");
        service.printPersons(byAge);

        List<Hobby> hobbies = createHobbies();

        Map<Person, List<Hobby>> map = new HashMap<>();
        map.put(raluca, hobbies);
        map.put(sorin, List.of(hobbies.get(1)));

        service.printHobbies(raluca, map);
    }

    private static List<Hobby> createHobbies() {
        Address address1 = new Address("Str Sforii", "Brasov", Country.ROMANIA);
        Address address2 = new Address("Str Sofiei", "Sofia", Country.BULGARIA);
        Address address3 = new Address("Str Budapestei", "Budapest", Country.HUNGARY);
        Address address4 = new Address("Str Moldovei", "Chisinau", Country.MOLDOVA);

        List<Address> hikingAddresses = new ArrayList<>();
        hikingAddresses.add(address1);
        hikingAddresses.add(address2);

        List<Address> tennisAddresses = new ArrayList<>();
        tennisAddresses.add(address3);
        tennisAddresses.add(address4);

        List<Hobby> hobbies = new ArrayList<>();
        hobbies.add(new Hobby("hiking", 1, hikingAddresses));
        hobbies.add(new Hobby("tennis", 2, tennisAddresses));
        return hobbies;
    }
}

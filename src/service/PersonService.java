package service;

import models.Address;
import models.Hobby;
import models.Person;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Methods for printing persons and their hobbies.
 */
public class PersonService {

    /**
     * Prints the name and age of every person in the set.
     */
    public void printPersons(Set<Person> persons) {
        for (Person person : persons) {
            System.out.println(person.getName() + " " + person.getAge());
        }
    }

    /**
     * Prints the hobbies of a person and the countries where they can be practiced.
     */
    public void printHobbies(Person person, Map<Person, List<Hobby>> map) {
        List<Hobby> hobbies = map.get(person);
        System.out.println("Hobbies of " + person.getName() + ":");
        for (Hobby hobby : hobbies) {
            System.out.print(hobby.getName() + ": ");
            for (Address address : hobby.getAddresses()) {
                System.out.print(address.getCountry() + " ");
            }
            System.out.println();
        }
    }
}

package models;

public class Hired extends Person {

    private String company;

    public Hired(String name, int age, String company) {
        super(name, age);
        this.company = company;
    }
}

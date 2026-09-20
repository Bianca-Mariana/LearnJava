package models;

public class Contact {
    private String index;
    private String phoneNumber;
    private String firstName;
    private String lastName;

    private String firstMessage;
    private String secondMessage;

    public Contact(String index, String phoneNumber, String firstName, String lastName) {
        this.index = index;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean addMessage(String messageContent) {
        if (firstMessage == null) {
            firstMessage = messageContent;
            return true;
        } else if (secondMessage == null) {
            secondMessage = messageContent;
            return true;
        } else {
            System.out.println("Contactul " + firstName + " " + lastName + " are deja 2 mesaje salvate!");
            return false;
        }
    }

    public String getIndex() {
        return index;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstMessage() {
        return firstMessage;
    }

    public String getSecondMessage() {
        return secondMessage;
    }

    @Override
    public String toString() {
        return "Contact " + index + ": " + firstName + " " + lastName + " (Nr: " + phoneNumber + ")";
    }
}

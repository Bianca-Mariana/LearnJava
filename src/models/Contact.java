package models;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String index;
    private String phoneNumber;
    private String firstName;
    private String lastName;

    private List<String> messages;

    public Contact(String index, String phoneNumber, String firstName, String lastName) {
        this.index = index;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.messages = new ArrayList<>();
    }

    public void addMessage(String messageContent) {
        messages.add(messageContent);
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
        if (messages.size() < 1) {
            return null;
        }
        return messages.get(0);
    }

    public String getSecondMessage() {
        if (messages.size() < 2) {
            return null;
        }
        return messages.get(1);
    }

    @Override
    public String toString() {
        return "Contact " + index + ": " + firstName + " " + lastName + " (Nr: " + phoneNumber + ")";
    }
}

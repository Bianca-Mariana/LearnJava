package models;

import interfaces.Phone;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePhone implements Phone {
    private final int batteryLife;
    private int currentBatteryLife;
    private final String serialNumber;
    private String color;
    private String material;
    private String brand;
    private String model;

    private Contact firstContact;
    private Contact secondContact;

    private List<String> callHistory;

    public BasePhone(String brand, String model, int batteryLife, String serialNumber, String color, String material) {
        this.brand = brand;
        this.model = model;
        this.batteryLife = batteryLife;
        this.currentBatteryLife = batteryLife;
        this.serialNumber = serialNumber;
        this.color = color;
        this.material = material;
        this.callHistory = new ArrayList<>();
    }

    @Override
    public void addContact(String index, String phoneNumber, String firstName, String lastName) {
        Contact contact = new Contact(index, phoneNumber, firstName, lastName);
        if (index.equals("1")) {
            this.firstContact = contact;
        } else if (index.equals("2")) {
            this.secondContact = contact;
        } else {
            System.out.println("Doar contactul 1 sau 2 poate fi adaugat.");
        }
    }

    @Override
    public Contact getFirstContact() {
        if (firstContact != null) {
            System.out.println(firstContact);
        } else {
            System.out.println("Nu exista primul contact.");
        }
        return firstContact;
    }

    @Override
    public Contact getLastContact() {
        if (secondContact != null) {
            System.out.println(secondContact);
            return secondContact;
        } else if (firstContact != null) {
            System.out.println(firstContact);
            return firstContact;
        } else {
            System.out.println("Nu exista contacte.");
            return null;
        }
    }

    private Contact findContactByPhoneNumber(String phoneNumber) {
        if (firstContact != null && firstContact.getPhoneNumber().equals(phoneNumber)) {
            return firstContact;
        }
        if (secondContact != null && secondContact.getPhoneNumber().equals(phoneNumber)) {
            return secondContact;
        }
        return null;
    }

    @Override
    public void sendMessage(String phoneNumber, String messageContent) {
        if (messageContent == null || messageContent.length() > 500) {
            System.out.println("Eroare: Mesajul depaseste 500 de caractere.");
            return;
        }

        if (currentBatteryLife < 1) {
            System.out.println("Baterie insuficienta pentru a trimite mesaj.");
            return;
        }

        Contact contact = findContactByPhoneNumber(phoneNumber);
        if (contact == null) {
            System.out.println("Contactul nu a fost gasit.");
            return;
        }

        boolean added = contact.addMessage(messageContent);
        if (added) {
            currentBatteryLife -= 1;
        }
    }

    @Override
    public void getFirstMessage(String phoneNumber) {
        Contact contact = findContactByPhoneNumber(phoneNumber);
        if (contact == null) {
            System.out.println("Contactul nu a fost gasit.");
            return;
        }
        if (contact.getFirstMessage() != null) {
            System.out.println("Primul mesaj (" + contact.getFirstName() + "): " + contact.getFirstMessage());
        } else {
            System.out.println("Nu exista primul mesaj.");
        }
    }

    @Override
    public void getSecondMessage(String phoneNumber) {
        Contact contact = findContactByPhoneNumber(phoneNumber);
        if (contact == null) {
            System.out.println("Contactul nu a fost gasit.");
            return;
        }
        if (contact.getSecondMessage() != null) {
            System.out.println("Al doilea mesaj (" + contact.getFirstName() + "): " + contact.getSecondMessage());
        } else {
            System.out.println("Nu exista al doilea mesaj.");
        }
    }

    @Override
    public void call(String phoneNumber) {
        if (currentBatteryLife < 2) {
            System.out.println("Baterie insuficienta pentru apel.");
            return;
        }

        currentBatteryLife -= 2;
        Contact contact = findContactByPhoneNumber(phoneNumber);
        
        String nume = phoneNumber;
        if (contact != null) {
            nume = contact.getFirstName() + " " + contact.getLastName();
        }

        callHistory.add("Apel catre " + nume + " (" + phoneNumber + ")");
    }

    @Override
    public void viewHistory() {
        System.out.println("Istoric apeluri (" + brand + " " + model + "):");
        if (callHistory.isEmpty()) {
            System.out.println("Nu exista apeluri in istoric.");
        } else {
            for (String call : callHistory) {
                System.out.println("- " + call);
            }
        }
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public int getCurrentBatteryLife() {
        return currentBatteryLife;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}

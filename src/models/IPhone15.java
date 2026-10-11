package models;

public class IPhone15 extends Apple {

    public IPhone15() {
        super("iPhone 15", 26, "AP67890", "Albastru", "Sticla/Aluminiu");
    }

    public IPhone15(String serialNumber, String color, String material) {
        super("iPhone 15", 26, serialNumber, color, material);
    }
}

package models;

public class IPhone14 extends Apple {

    public IPhone14() {
        super("iPhone 14", 24, "AP12345", "Negru", "Sticla/Aluminiu");
    }

    public IPhone14(String serialNumber, String color, String material) {
        super("iPhone 14", 24, serialNumber, color, material);
    }
}

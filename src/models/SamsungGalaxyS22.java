package models;

public class SamsungGalaxyS22 extends Samsung {

    public SamsungGalaxyS22() {
        super("Galaxy S22", 28, "SN654321", "Negru", "Sticla/Aluminiu");
    }

    public SamsungGalaxyS22(String serialNumber, String color, String material) {
        super("Galaxy S22", 28, serialNumber, color, material);
    }
}

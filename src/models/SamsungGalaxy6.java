package models;

public class SamsungGalaxy6 extends Samsung {

    public SamsungGalaxy6() {
        super("Galaxy S6", 20, "SN123456", "Negru", "Aluminiu/Sticla");
    }

    public SamsungGalaxy6(String serialNumber, String color, String material) {
        super("Galaxy S6", 20, serialNumber, color, material);
    }
}

package models;

public abstract class Samsung extends BasePhone {
    public Samsung(String model, int batteryLife, String serialNumber, String color, String material) {
        super("Samsung", model, batteryLife, serialNumber, color, material);
    }
}

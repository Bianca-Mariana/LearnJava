package models;

public abstract class Apple extends BasePhone {
    public Apple(String model, int batteryLife, String serialNumber, String color, String material) {
        super("Apple", model, batteryLife, serialNumber, color, material);
    }
}

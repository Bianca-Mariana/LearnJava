package models;

public abstract class Dacia extends Car {

    public Dacia(double fuelTankSize, FuelType fuelType, int gears, double consumptionPer100Km,
                 double availableFuel, String chassisNumber) {
        super(fuelTankSize, fuelType, gears, consumptionPer100Km, availableFuel, chassisNumber);
    }

    public Dacia(double fuelTankSize, FuelType fuelType, int gears, double consumptionPer100Km,
                 double availableFuel, int tireSize, String chassisNumber) {
        super(fuelTankSize, fuelType, gears, consumptionPer100Km, availableFuel, tireSize, chassisNumber);
    }
}

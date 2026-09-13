package models;

public abstract class Volkswagen extends Car {

    public Volkswagen(double fuelTankSize, FuelType fuelType, int gears, double consumptionPer100Km,
                      double availableFuel, String chassisNumber) {
        super(fuelTankSize, fuelType, gears, consumptionPer100Km, availableFuel, chassisNumber);
    }

    public Volkswagen(double fuelTankSize, FuelType fuelType, int gears, double consumptionPer100Km,
                      double availableFuel, int tireSize, String chassisNumber) {
        super(fuelTankSize, fuelType, gears, consumptionPer100Km, availableFuel, tireSize, chassisNumber);
    }
}

package models;

import interfaces.Vehicle;

public abstract class Car implements Vehicle {

    private final double fuelTankSize;
    private final FuelType fuelType;
    private final int gears;
    private final double consumptionPer100Km;
    private final String chassisNumber;

    private double availableFuel;
    private int tireSize = 15;

    private int currentGear = 1;
    private double totalKm;
    private double fuelConsumed;

    public Car(double fuelTankSize, FuelType fuelType, int gears, double consumptionPer100Km,
               double availableFuel, String chassisNumber) {
        this.fuelTankSize = fuelTankSize;
        this.fuelType = fuelType;
        this.gears = gears;
        this.consumptionPer100Km = consumptionPer100Km;
        this.availableFuel = availableFuel;
        this.chassisNumber = chassisNumber;
    }

    public Car(double fuelTankSize, FuelType fuelType, int gears, double consumptionPer100Km,
               double availableFuel, int tireSize, String chassisNumber) {
        this(fuelTankSize, fuelType, gears, consumptionPer100Km, availableFuel, chassisNumber);
        this.tireSize = tireSize;
    }

    @Override
    public void start() {
        this.totalKm = 0;
        this.fuelConsumed = 0;
    }

    @Override
    public void stop() {
    }

    @Override
    public void drive(double km) {
        double consumed = (consumptionPer100Km * km) / 100;
        availableFuel -= consumed;
        fuelConsumed += consumed;
        totalKm += km;
    }

    public void shiftGear(int gear) {

        this.currentGear = gear;
    }

    public float getAvailableFuel() {

        return (float) availableFuel;
    }

    public float getAverageFuelConsumption() {
        if (totalKm == 0) {
            return 0;
        }
        return (float) ((fuelConsumed / totalKm) * 100);
    }

    public int getTireSize() {
        return tireSize;
    }

    public void setTireSize(int tireSize) {

        this.tireSize = tireSize;
    }
}

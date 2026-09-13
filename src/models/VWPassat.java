package models;

public class VWPassat extends Volkswagen {

    public VWPassat(double availableFuel, String chassisNumber) {
        super(58, FuelType.PETROL, 5, 7.4, availableFuel, chassisNumber);
    }

    public VWPassat(double availableFuel, int tireSize, String chassisNumber) {
        super(58, FuelType.PETROL, 5, 7.4, availableFuel, tireSize, chassisNumber);
    }
}

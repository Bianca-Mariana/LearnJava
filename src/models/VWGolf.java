package models;

public class VWGolf extends Volkswagen {

    public VWGolf(double availableFuel, String chassisNumber) {
        super(52, FuelType.DIESEL, 6, 4.9, availableFuel, chassisNumber);
    }

    public VWGolf(double availableFuel, int tireSize, String chassisNumber) {
        super(52, FuelType.DIESEL, 6, 4.9, availableFuel, tireSize, chassisNumber);
    }
}

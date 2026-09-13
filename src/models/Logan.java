package models;

public class Logan extends Dacia {

    public Logan(double availableFuel, String chassisNumber) {
        super(42, FuelType.PETROL, 5, 6.3, availableFuel, chassisNumber);
    }

    public Logan(double availableFuel, int tireSize, String chassisNumber) {
        super(42, FuelType.PETROL, 5, 6.3, availableFuel, tireSize, chassisNumber);
    }
}

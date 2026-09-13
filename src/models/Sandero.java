package models;

public class Sandero extends Dacia {

    public Sandero(double availableFuel, String chassisNumber) {
        super(38, FuelType.DIESEL, 5, 5.1, availableFuel, chassisNumber);
    }

    public Sandero(double availableFuel, int tireSize, String chassisNumber) {
        super(38, FuelType.DIESEL, 5, 5.1, availableFuel, tireSize, chassisNumber);
    }
}

import interfaces.Vehicle;
import models.Car;
import models.Logan;
import models.Sandero;
import models.VWGolf;
import models.VWPassat;

public class Main {
    public static void main(String[] args) {

        System.out.println("Test Logan:");
        Car car = new Logan(27, "oiqe0934hkkadsn");
        car.start();
        car.shiftGear(1);
        car.drive(0.01);
        car.shiftGear(2);
        car.drive(0.02);
        car.shiftGear(3);
        car.drive(0.5);
        car.shiftGear(4);
        car.drive(0.5);
        car.shiftGear(4);
        car.drive(0.5);
        car.shiftGear(5);
        car.drive(10);
        car.shiftGear(4);
        car.drive(0.5);
        car.shiftGear(3);
        car.drive(0.1);
        car.stop();

        float fuel = car.getAvailableFuel();
        float consumption = car.getAverageFuelConsumption();
        System.out.printf("Logan fuel: %.2f\n", fuel);
        System.out.printf("Logan consumption: %.2f\n\n", consumption);


        System.out.println("Test Sandero:");
        Car sandero = new Sandero(25, "sandero893478");
        sandero.start();
        sandero.shiftGear(2);
        sandero.drive(20);
        sandero.stop();
        System.out.printf("Sandero fuel: %.2f\n", sandero.getAvailableFuel());
        System.out.printf("Sandero consumption: %.2f\n\n", sandero.getAverageFuelConsumption());


        System.out.println("Test Golf:");
        Vehicle vehicle = new VWGolf(30, "1987ddkshik289");
        vehicle.start();
        vehicle.drive(1);
        vehicle.stop();

        Car golf = (Car) vehicle;
        float golfFuel = golf.getAvailableFuel();
        float golfConsumption = golf.getAverageFuelConsumption();
        System.out.printf("Golf fuel: %.2f\n", golfFuel);
        System.out.printf("Golf consumption: %.2f\n\n", golfConsumption);


        System.out.println("Test Passat:");
        Car passat = new VWPassat(40, "passat776655");
        passat.start();
        passat.shiftGear(3);
        passat.drive(50);
        passat.stop();
        System.out.printf("Passat fuel: %.2f\n", passat.getAvailableFuel());
        System.out.printf("Passat consumption: %.2f\n", passat.getAverageFuelConsumption());
    }
}

package vehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
@SuppressWarnings("Duplicates")
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carArgs = reader.readLine().split(" ");
        String[] truckArgs = reader.readLine().split(" ");
        String[] busArgs = reader.readLine().split(" ");

        Vehicle car = new Car(Double.parseDouble(carArgs[1]),Double.parseDouble(carArgs[2]), Double.parseDouble(carArgs[3]));
        Vehicle truck = new Truck(Double.parseDouble(truckArgs[1]),Double.parseDouble(truckArgs[2]), Double.parseDouble(truckArgs[3]));
        Vehicle bus = new Bus(Double.parseDouble(busArgs[1]),Double.parseDouble(busArgs[2]), Double.parseDouble(busArgs[3]));

        int driveCommandCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < driveCommandCount; i++) {
            String[] currentCommand = reader.readLine().split(" ");

            String driveCommand = currentCommand[0];
            try {
            switch (driveCommand) {
                case "Drive":
                    String currentVehicle = currentCommand[1];
                    double givenKmToTravel = Double.parseDouble(currentCommand[2]);
                    if (currentVehicle.equals("Car")) {
                        System.out.println(car.drivenGivenDistance(givenKmToTravel));
                    } else if (currentVehicle.equals("Truck")) {
                        System.out.println(truck.drivenGivenDistance(givenKmToTravel));
                    } else {
                        System.out.println(bus.drivenGivenDistance(givenKmToTravel));
                    }
                    break;
                case "Refuel":
                    currentVehicle = currentCommand[1];
                    double givenLitters = Double.parseDouble(currentCommand[2]);
                    if (currentVehicle.equals("Car")) {
                        car.refuel(givenLitters);
                    } else if (currentVehicle.equals("Truck")) {
                        truck.refuel(givenLitters);
                    } else {
                        bus.refuel(givenLitters);
                    }
                    break;
                case "DriveEmpty":
                    currentVehicle = currentCommand[1];
                    givenLitters = Double.parseDouble(currentCommand[2]);
                    if (currentVehicle.equals("Bus")) {
                        System.out.println(((Bus) bus).driveEmpty(givenLitters));
                    }
                    break;
            }
        }
        catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
        }
        System.out.println(String.format("Car: %.2f", car.getFuelQuantity()));
        System.out.println(String.format("Truck: %.2f", truck.getFuelQuantity()));
        System.out.println(String.format("Bus: %.2f", bus.getFuelQuantity()));


    }
}

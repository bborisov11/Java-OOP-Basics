package vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carArgs = reader.readLine().split(" ");
        String[] truckArgs = reader.readLine().split(" ");

        Vehicle car = new Car(Double.parseDouble(carArgs[1]),Double.parseDouble(carArgs[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckArgs[1]),Double.parseDouble(truckArgs[2]));

        int driveCommandCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < driveCommandCount; i++) {
            String[] currentCommand = reader.readLine().split(" ");

            String driveCommand = currentCommand[0];

            switch (driveCommand) {
                case "Drive":
                    String currentVehicle = currentCommand[1];
                    double givenKmToTravel = Double.parseDouble(currentCommand[2]);
                    if(currentVehicle.equals("Car")) {
                        System.out.println(car.drivenGivenDistance(givenKmToTravel));
                    }
                    else if(currentVehicle.equals("Truck")) {
                        System.out.println(truck.drivenGivenDistance(givenKmToTravel));
                    }
                    break;
                case "Refuel":
                     currentVehicle = currentCommand[1];
                    double givenLitters = Double.parseDouble(currentCommand[2]);
                    if(currentVehicle.equals("Car")) {
                        car.refuel(givenLitters);
                    }
                    else if(currentVehicle.equals("Truck")) {
                        truck.refuel(givenLitters);
                    }
            }
        }
        System.out.println(String.format("Car: %.2f",car.getFuelQuantity()));
        System.out.println(String.format("Truck: %.2f",truck.getFuelQuantity()));

    }
}

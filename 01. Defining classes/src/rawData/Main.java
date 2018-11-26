package rawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] input = reader.readLine().split(" ");

            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2ge = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);

            Car car = new Car(model, new Engine(engineSpeed,enginePower), new Cargo(cargoWeight,cargoType)
                    , new Tire(tire1Pressure,tire1Age,tire2Pressure,tire2ge,tire3Pressure,tire3Age,tire4Pressure,tire4Age));

            cars.add(car);
         }
         String command = reader.readLine();

        if(command.equals("fragile")) {
            cars.stream()
                    .filter(x -> x.getCargo().getCargoType().equals("fragile") &&
                    x.getTire().getTire1Pressure() < 1 || x.getTire().getTire2Pressure() < 1 || x.getTire().getTire3Pressure() < 1 ||
                            x.getTire().getTire4Pressure() < 1)
                    .forEach(x -> System.out.println(x.getModel()));
        }
        else if(command.equals("flamable")) {
            cars.stream()
                    .filter(x -> x.getCargo().getCargoType().equals("flamable"))
                    .filter(x -> x.getEngine().getEnginePower() > 250)
                    .forEach(x -> System.out.println(x.getModel()));
        }
    }
}

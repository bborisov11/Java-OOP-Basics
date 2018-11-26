package carSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());
        List<Engine> engines = new ArrayList<>();

        Engine engine;
        for (int i = 0; i < count; i++) {
            String[] input = reader.readLine().split(" ");

            String model = input[0];
            int power = Integer.parseInt(input[1]);

            if (input.length == 2) {
                engine = new Engine(model, power);
            } else if (input.length == 3) {
                if(isNumeric(input[2])) {
                    String displacement = input[2];
                    engine = new Engine(model, power, displacement);
                }
                else {
                    String efficiency = input[2];
                    engine = new Engine(model, power,"n/a", efficiency);
                }
            } else {
                String displacement = input[2];
                String efficiency = input[3];
                engine = new Engine(model, power, displacement, efficiency);
            }
            engines.add(engine);
        }
        int countSec = Integer.parseInt(reader.readLine());

        List<Car> cars = new ArrayList<>();

        Car car;
        for (int i = 0; i < countSec; i++) {
            String[] input = reader.readLine().split(" ");

            String model = input[0];
            String engineStr = input[1];
            Engine carsEngine = engines.stream().filter(x -> x.getModel().equals(engineStr)).findFirst().get();

            if (input.length == 2) {
                car = new Car(model, carsEngine);
            } else if (input.length == 3) {
                if(isNumeric(input[2])) {
                    String weight = input[2];
                    car = new Car(model, carsEngine, weight);
                }
                else {
                    String efficiency = input[2];
                    car = new Car(model, carsEngine,"n/a", efficiency);
                }

            } else {
                String weight = input[2];
                String color = input[3];
                car = new Car(model, carsEngine, weight, color);
            }
            cars.add(car);
        }

        cars.forEach(x -> System.out.println(x.toString()));
    }

    private static boolean isNumeric(String str) {
        try {
            int num = Integer.parseInt(str);
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }

}

import Cars.CarManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        CarManager carManager = new CarManager();

        while(!(input = reader.readLine()).equals("Cops Are Here")) {
            String[] inputArgs = input.split(" ");
            String command = inputArgs[0];
            switch (command) {
                case "register":
                    int carId = Integer.parseInt(inputArgs[1]);
                    String type = inputArgs[2];
                    String brand = inputArgs[3];
                    String model = inputArgs[4];
                    int year = Integer.parseInt(inputArgs[5]);
                    int horsepower = Integer.parseInt(inputArgs[6]);
                    int aceleration = Integer.parseInt(inputArgs[7]);
                    int suspention = Integer.parseInt(inputArgs[8]);
                    int durability = Integer.parseInt(inputArgs[9]);
                    carManager.register(carId,type,brand,model,year,horsepower,aceleration,suspention,durability);
                    break;
                case "open":
                    int raceId = Integer.parseInt(inputArgs[1]);
                     type = inputArgs[2];
                    int length = Integer.parseInt(inputArgs[3]);
                    String route = inputArgs[4];
                    int prizePool = Integer.parseInt(inputArgs[5]);
                    if(type.equals("TimeLimit") || type.equals("Circuit")) {
                        int parameter = Integer.parseInt(inputArgs[6]);
                        carManager.open(raceId,type,length,route,prizePool,parameter);
                    }
                    else {
                        carManager.open(raceId, type, length, route, prizePool);
                    }
                    break;
                case "participate":
                    carId = Integer.parseInt(inputArgs[1]);
                    raceId = Integer.parseInt(inputArgs[2]);
                    carManager.participate(carId,raceId);
                    break;
                case "check":
                    carId = Integer.parseInt(inputArgs[1]);
                    System.out.println(carManager.check(carId));
                    break;
                case "start":
                    raceId = Integer.parseInt(inputArgs[1]);
                    System.out.println(carManager.start(raceId));
                    break;
                case "park":
                    carId = Integer.parseInt(inputArgs[1]);
                    carManager.park(carId);
                    break;
                case "unpark":
                    carId = Integer.parseInt(inputArgs[1]);
                    carManager.unpark(carId);
                    break;
                case "tune":
                    int tuneIndex = Integer.parseInt(inputArgs[1]);
                    String addOn = inputArgs[2];
                    carManager.tune(tuneIndex,addOn);
                    break;
            }
        }

    }
}

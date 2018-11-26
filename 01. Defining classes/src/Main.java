import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Car> cars = new LinkedHashMap<>();

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {

            String[] input = reader.readLine().split(" ");

            String name = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelForKm = Double.parseDouble(input[2]);
            Car car = new Car(name,fuelAmount,fuelForKm);

            cars.putIfAbsent(name,car);
        }

        String command;
        while(!(command = reader.readLine()).equals("End")) {
            String[] input = command.split(" ");

            if(!input[0].equals("Drive")) {
                continue;
            }
            String model = input[1];

            if(!cars.containsKey(model)) {
                continue;
            }
            long amountKm = Long.parseLong(input[2]);

            cars.get(model).calculatingParameters(amountKm);
        }

        cars.forEach((key, value) -> System.out.println(String.format("%s %.2f %d",
                value.getModel(), value.getFuelAmount(), value.getDistanceTraveled())));

    }
}
 class Car {
    private String model;
    private double fuelAmount;
    private double fuelAmountForKm;
    private long distanceTraveled;

    public Car(String model, double fuelAmount, double fuelAmountForKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelAmountForKm = fuelAmountForKm;
        this.distanceTraveled = 0;
    }

    public void calculatingParameters(long amountKm) {
        double fuelAmount = amountKm * this.fuelAmountForKm;
        if(fuelAmount > this.fuelAmount) {
            System.out.println("Insufficient fuel for the drive");
        }
        else {
            this.distanceTraveled += amountKm;
            this.fuelAmount -= fuelAmount;
        }
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelAmountForKm() {
        return fuelAmountForKm;
    }

    public void setFuelAmountForKm(double fuelAmountForKm) {
        this.fuelAmountForKm = fuelAmountForKm;
    }

    public long getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(long distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }
}


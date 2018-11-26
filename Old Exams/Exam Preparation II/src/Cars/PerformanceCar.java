package Cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction,
                          int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }


    public List<String> getAddOns() {
        return addOns;
    }

    @Override
    public String toString() {
        StringBuilder performanceCar = new StringBuilder();
        performanceCar.append(super.toString()).append("Add-ons: ")
                .append(this.addOns.size() != 0 ? String.join(", ",this.addOns) : "None");
        return performanceCar.toString();
    }
}

package vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double fuelConsumptionInLittersPerKm) {
        super(fuelQuantity, fuelConsumptionInLittersPerKm + 0.9);
    }

    @Override
    public void refuel(double additionalLitters) {
        this.setFuelQuantity(this.getFuelQuantity() + additionalLitters);
    }

    @Override
    public String drivenGivenDistance(double distance) {
        if(distance * this.getFuelConsumptionInLittersPerKm() > this.getFuelQuantity()) {
            return "Car needs refueling";
        }
        else {
            DecimalFormat df = new DecimalFormat("##.##");
            double fuelForGivenKm = distance * this.getFuelConsumptionInLittersPerKm();
                this.setFuelQuantity(this.getFuelQuantity() - fuelForGivenKm);
                return "Car travelled "+ df.format(distance) +" km";
        }
    }


}

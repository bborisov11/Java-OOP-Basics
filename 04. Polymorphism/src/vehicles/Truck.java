package vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumptionInLittersPerKm) {
        super(fuelQuantity, fuelConsumptionInLittersPerKm + 1.6);
    }

    @Override
    public void refuel(double additionalLitters) {
        this.setFuelQuantity(this.getFuelQuantity() + (additionalLitters * 0.95));
    }

    @Override
    public String drivenGivenDistance(double distance) {
        if(distance * this.getFuelConsumptionInLittersPerKm() > this.getFuelQuantity()) {
            return "Truck needs refueling";
        }
        else {
            DecimalFormat df = new DecimalFormat("##.##");
            double fuelForGivenKm = distance * this.getFuelConsumptionInLittersPerKm();
            this.setFuelQuantity(this.getFuelQuantity() - fuelForGivenKm);
            return "Truck travelled "+ df.format(distance) +" km";
        }
    }
}

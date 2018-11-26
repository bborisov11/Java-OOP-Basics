package vehiclesExtension;

import java.text.DecimalFormat;
@SuppressWarnings("Duplicates")
public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumptionInLittersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLittersPerKm + 1.6, tankCapacity);
    }

    @Override
    public void refuel(double additionalLitters) {
        if(additionalLitters <= 0) {
            throw new IllegalArgumentException(FUEL_MUST_BE_A_POSITIVE_NUMBER);
        }
        if(additionalLitters > this.getTankCapacity()) {
            throw new IllegalArgumentException(CANNOT_FIT_FUEL_IN_TANK);
        }
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

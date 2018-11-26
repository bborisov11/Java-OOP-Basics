package vehiclesExtension;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double fuelConsumptionInLittersPerKm, double tankCapacty) {
        super(fuelQuantity, fuelConsumptionInLittersPerKm + 0.9, tankCapacty);
    }

    @Override
    public void refuel(double additionalLitters) {
        if(additionalLitters <= 0) {
            throw new IllegalArgumentException(FUEL_MUST_BE_A_POSITIVE_NUMBER);
        }
        if(additionalLitters > this.getTankCapacity()) {
            throw new IllegalArgumentException(CANNOT_FIT_FUEL_IN_TANK);
        }
        this.setFuelQuantity(this.getFuelQuantity() + additionalLitters);
    }

    @Override
    @SuppressWarnings("Duplicates")
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

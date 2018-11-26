package vehiclesExtension;

import java.text.DecimalFormat;
@SuppressWarnings("Duplicates")
public class Bus extends Vehicle {
    public Bus(double fuelQuantity, double fuelConsumptionInLittersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLittersPerKm, tankCapacity);
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
    public String drivenGivenDistance(double distance) {
        if(distance * this.getFuelConsumptionInLittersPerKm() > this.getFuelQuantity()) {
            return "Bus needs refueling";
        }
        else {
            DecimalFormat df = new DecimalFormat("##.##");
            double fuelForGivenKm = distance * (this.getFuelConsumptionInLittersPerKm() + 1.4);
            this.setFuelQuantity(this.getFuelQuantity() - fuelForGivenKm);
            return "Bus travelled "+ df.format(distance) +" km";
        }
    }
    public String driveEmpty(double distance) {
        if(distance * this.getFuelConsumptionInLittersPerKm() > this.getFuelQuantity()) {
            return "Bus needs refueling";
        }
        else {
            DecimalFormat df = new DecimalFormat("##.##");
            double fuelForGivenKm = distance * this.getFuelConsumptionInLittersPerKm();
            this.setFuelQuantity(this.getFuelQuantity() - fuelForGivenKm);
            return "Bus travelled "+ df.format(distance) +" km";
        }
    }
}

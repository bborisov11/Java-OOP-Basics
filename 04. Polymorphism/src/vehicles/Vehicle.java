package vehicles;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumptionInLittersPerKm;

    public Vehicle(double fuelQuantity, double fuelConsumptionInLittersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionInLittersPerKm = fuelConsumptionInLittersPerKm;
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelConsumptionInLittersPerKm() {
        return fuelConsumptionInLittersPerKm;
    }

    protected void setFuelConsumptionInLittersPerKm(double fuelConsumptionInLittersPerKm) {
        this.fuelConsumptionInLittersPerKm = fuelConsumptionInLittersPerKm;
    }

    public abstract void refuel(double additionalLitters);

    public abstract String drivenGivenDistance(double distance);
}

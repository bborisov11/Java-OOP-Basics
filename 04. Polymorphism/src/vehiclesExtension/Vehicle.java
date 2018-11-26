package vehiclesExtension;

public abstract class Vehicle {

    protected static final String FUEL_MUST_BE_A_POSITIVE_NUMBER = "Fuel must be a positive number";
    public static final String CANNOT_FIT_FUEL_IN_TANK = "Cannot fit fuel in tank";
    private double fuelQuantity;
    private double fuelConsumptionInLittersPerKm;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumptionInLittersPerKm, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.fuelConsumptionInLittersPerKm = fuelConsumptionInLittersPerKm;
        this.setTankCapacity(tankCapacity);
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {

        this.tankCapacity = tankCapacity;
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

package avatar.benders;

public class FireBender extends BaseBenders{
    private double heatAggression;


    public FireBender(String name, int power, double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
    }

    @Override
    public double currentPower() {
        return this.heatAggression * this.getPower();
    }

    @Override
    public String toString() {
        StringBuilder fireBender = new StringBuilder();
        fireBender.append("Fire Bender: ").append(super.toString()).append(", ").append("Heat Aggression: ")
                .append(String.format("%.2f", this.heatAggression));
        return fireBender.toString();
    }
}

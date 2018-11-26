package avatar.benders;

public class WaterBender extends BaseBenders{
    private double waterClarity;

    public WaterBender(String name, int power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
    }

    @Override
    public double currentPower() {
        return this.waterClarity * this.getPower();
    }

    @Override
    public String toString() {
        StringBuilder waterBender = new StringBuilder();
        waterBender.append("Water Bender: ").append(super.toString()).append(", ").append("Water Clarity: ")
                .append(String.format("%.2f", this.waterClarity));
        return waterBender.toString();
    }
}

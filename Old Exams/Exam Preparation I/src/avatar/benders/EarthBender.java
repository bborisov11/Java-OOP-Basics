package avatar.benders;

public class EarthBender extends BaseBenders{
    private double groundSaturation;

    public EarthBender(String name, int power, double groundSaturation) {
        super(name, power);
        this.groundSaturation = groundSaturation;
    }

    @Override
    public double currentPower() {
        return this.groundSaturation * this.getPower();
    }

    @Override
    public String toString() {
        StringBuilder earthBender = new StringBuilder();
        earthBender.append("Earth Bender: ").append(super.toString()).append(", ").append("Ground Saturation: ")
                .append(String.format("%.2f", this.groundSaturation));
        return earthBender.toString();
    }
}

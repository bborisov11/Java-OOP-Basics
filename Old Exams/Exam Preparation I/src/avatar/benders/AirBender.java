package avatar.benders;

public class AirBender extends BaseBenders{

    private double aerialIntegirty;

    public AirBender(String name, int power, double aerialIntegirty) {
        super(name, power);
        this.aerialIntegirty = aerialIntegirty;
    }

    @Override
    public double currentPower() {
        return this.aerialIntegirty * this.getPower();
    }

    @Override
    public String toString() {
        StringBuilder airBender = new StringBuilder();
        airBender.append("Air Bender: ").append(super.toString()).append(", ").append("Aerial Integrity: ")
                .append(String.format("%.2f", this.aerialIntegirty));
        return airBender.toString();
    }
}

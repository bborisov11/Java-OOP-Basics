package avatar.monuments;

public class AirMonument extends BaseMonuments {
    private int airAffinity;

    public AirMonument(String name, int airAffinity) {
        super(name);
        this.airAffinity = airAffinity;
    }

    public int getAffinity() {
        return airAffinity;
    }

    @Override
    public String toString() {
        StringBuilder airMonument = new StringBuilder();
        airMonument.append("Air Monument: ").append(super.toString()).append(", ").append("Air Affinity: ").append(this.airAffinity);
        return airMonument.toString();
    }
}

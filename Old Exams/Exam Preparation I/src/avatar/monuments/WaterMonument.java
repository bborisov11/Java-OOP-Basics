package avatar.monuments;

public class WaterMonument extends BaseMonuments{
    private int waterAffinity;

    public WaterMonument(String name, int waterAffinity) {
        super(name);
        this.waterAffinity = waterAffinity;
    }


    public int getAffinity() {
        return waterAffinity;
    }

    @Override
    public String toString() {
        StringBuilder waterMonument = new StringBuilder();
        waterMonument.append("Water Monument: ").append(super.toString()).append(", ").append("Water Affinity: ").append(this.waterAffinity);
        return waterMonument.toString();
    }
}

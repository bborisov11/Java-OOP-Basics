package avatar.monuments;

public class EarthMonument extends BaseMonuments{
    private int earthAffinity;

    public EarthMonument(String name, int earthAffinity) {
        super(name);
        this.earthAffinity = earthAffinity;
    }


    public int getAffinity() {
        return earthAffinity;
    }

    @Override
    public String toString() {
        StringBuilder earthMonument = new StringBuilder();
        earthMonument.append("Earth Monument: ").append(super.toString()).append(", ").append("Earth Affinity: ")
                .append(this.earthAffinity);
        return earthMonument.toString();
    }
}

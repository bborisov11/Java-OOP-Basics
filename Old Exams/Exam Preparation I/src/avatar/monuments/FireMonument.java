package avatar.monuments;

public class FireMonument extends BaseMonuments{
    private int fireAffinity;

    public FireMonument(String name, int fireAffinity) {
        super(name);
        this.fireAffinity = fireAffinity;
    }

    public int getAffinity() {
        return fireAffinity;
    }

    @Override
    public String toString() {
        StringBuilder fireMonument = new StringBuilder();
        fireMonument.append("Fire Monument: ").append(super.toString()).append(", ").append("Fire Affinity: ").append(this.fireAffinity);
        return fireMonument.toString();
    }
}

package catLady;

public class Siamese extends Cat {
    private String name;
    private double earSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEarSize() {
        return earSize;
    }

    public void setEarSize(double earSize) {
        this.earSize = earSize;
    }

    public Siamese(String name, double earSize) {
        this.name = name;
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f", this.name, this.earSize);
    }
}

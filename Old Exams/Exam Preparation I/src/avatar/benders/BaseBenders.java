package avatar.benders;

public abstract class BaseBenders {
    private String name;
    private int power;

    public BaseBenders(String name, int power) {
        this.name = name;
        this.power = power;
    }


    public int getPower() {
        return power;
    }
    public abstract double currentPower();

    @Override
    public String toString() {
        StringBuilder baseBenders = new StringBuilder();
        baseBenders.append(this.name).append(", ").append("Power: ").append(this.power);
        return baseBenders.toString();
    }
}

package ferrari;

public class Ferrari implements Car{
    private String driversName;

    public Ferrari(String driversName) {
        this.driversName = driversName;
    }

    @Override
    public String getModel() {
        return "488-Spider";
    }

    @Override
    public String useBreaks() {
        return "Brakes!";
    }

    @Override
    public String pushGasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String getDriversName() {
        return this.driversName;
    }

    @Override
    public String toString() {
        return this.getModel() + "/" + this.useBreaks() + "/" + this.pushGasPedal() + "/" + this.getDriversName();
    }
}

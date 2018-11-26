package carSalesman;

public class Engine {
    private String model;
    private int power;
    private String displacement;
    private String efficiency;


    public Engine(String model, int power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, String displacement) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = "n/a";
    }


    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return   model +":" + '\n' +
                "    Power: " + power + '\n' +
                "    Displacement: " + displacement + '\n' +
                "    Efficiency: " + efficiency;
    }
}

package militaryElite.classImpl;

public class RepairImpl {
    private String name;
    private int hoursWorked;

    public RepairImpl(String name, int hoursWorked) {
        this.name = name;
        this.hoursWorked = hoursWorked;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        StringBuilder repair = new StringBuilder();
        repair.append("  Part Name: ").append(this.name).append(" Hours Worked: ").append(this.hoursWorked);
        return repair.toString();
    }
}

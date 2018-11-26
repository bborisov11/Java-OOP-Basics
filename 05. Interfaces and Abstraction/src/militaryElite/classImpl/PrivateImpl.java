package militaryElite.classImpl;

import militaryElite.interfaces.Private;

public class PrivateImpl extends BaseSoldier implements Private {

    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(String.format("Salary: %.2f", this.salary));
        return sb.toString();
    }
}

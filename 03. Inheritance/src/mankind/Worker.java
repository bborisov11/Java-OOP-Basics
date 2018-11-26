package mankind;

public class Worker extends Human {

    private double weekSalaray;
    private double workHoursPerDay;
    private final String LAST_NAME_ERROR = "Expected length more than 3 symbols!Argument: lastName";
    private final String SALARY_ERROR = "Expected value mismatch!Argument: weekSalary";
    private final String WORKHOURS_PER_DAY = "Expected value mismatch!Argument: workHoursPerDay";

    public Worker(String firstName, String lastName, double weekSalaray, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalaray(weekSalaray);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    public void setLastName(String lastName) {
        if(lastName.length() < 3) {
            throw new IllegalArgumentException(LAST_NAME_ERROR);
        }
        super.setLastName(lastName);
    }

    public double getWeekSalaray() {
        return weekSalaray;
    }

    public void setWeekSalaray(double weekSalaray) {
        if(weekSalaray < 10) {
            throw new IllegalArgumentException(SALARY_ERROR);
        }
        this.weekSalaray = weekSalaray;
    }

    public double getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    public void setWorkHoursPerDay(double workHoursPerDay) {
        if(workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException(WORKHOURS_PER_DAY);
        }
        this.workHoursPerDay = workHoursPerDay;
    }
    public double earnedMoneyByHour() {
        return this.weekSalaray / (7 * workHoursPerDay);
    }


    @Override
    public String toString() {
        StringBuilder worker = new StringBuilder();
        return worker.append(super.toString()).append(System.lineSeparator())
                .append("Week Salary: ").append(String.format("%.2f",this.weekSalaray)).append(System.lineSeparator())
                .append("Hours per day: ").append(String.format("%.2f",this.workHoursPerDay)).append(System.lineSeparator())
                .append("Salary per hour: ").append(String.format("%.2f",this.earnedMoneyByHour())).toString();
    }
}

package militaryElite.classImpl;

import militaryElite.interfaces.Soldier;

public abstract class BaseSoldier implements Soldier {
    private int id;
    private String firstName;
    private String lastName;

    public BaseSoldier(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d ", this.firstName, this.lastName, this.id);
    }
}

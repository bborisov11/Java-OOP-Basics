package foodShortage;

public class Citizen implements BorderControl, BirthDate,Buyer {
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int foodBought;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.foodBought = 0;
    }

    @Override
    public boolean fakeIds(String id) {
        if(this.id.endsWith(id)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean getBirthDate(String date) {
        if(this.birthDate.endsWith(date)) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return this.birthDate;
    }

    @Override
    public void buyFood() {
        this.foodBought += 10;
    }

    @Override
    public int Food() {
        return this.foodBought;
    }
}

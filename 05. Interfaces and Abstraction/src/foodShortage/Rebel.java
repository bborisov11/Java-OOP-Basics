package foodShortage;

public class Rebel implements Buyer{
    private String name;
    private int age;
    private String group;
    private int foodBought;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.foodBought = 0;
    }

    @Override
    public void buyFood() {
        this.foodBought += 5;
    }

    @Override
    public int Food() {
        return this.foodBought;
    }
}

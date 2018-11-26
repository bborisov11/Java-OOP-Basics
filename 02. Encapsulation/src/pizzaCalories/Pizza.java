package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private int numberOfToppings;
    private Doughs dough;
    private List<Toppings> toppings;


    public Pizza(String name, int numberOfToppings) {
        this.toppings = new ArrayList<>();
        setName(name);
        setNumberOfToppings(numberOfToppings);
    }

    public void setNumberOfToppings(int numberOfToppings) {
        if(numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    private void setName(String name) {
        if(name.length() > 15 || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setDough(Doughs dough) {
        this.dough = dough;
    }

    public void addTopping(Toppings topping) {
        this.toppings.add(topping);
    }
    public void addDough(Doughs dough) {
        this.setDough(dough);
    }

}

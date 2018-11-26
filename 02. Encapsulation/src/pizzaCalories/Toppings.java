package pizzaCalories;

import java.util.HashMap;
import java.util.Map;

public class Toppings {
    private int weightInGrams;
    private String currentTopping;
    private final Map<String,Double> toppingsIng;

    public Toppings(String currentTopping, int weightInGrams) {
        this.currentTopping = currentTopping;
        this.weightInGrams = weightInGrams;
        this.toppingsIng = new HashMap<>();
        this.fillToppingsIng();
        this.containTopping();
        this.weightUnder50();
    }
    private void fillToppingsIng() {
        this.toppingsIng.put("Meat",1.2);
        this.toppingsIng.put("Veggies",0.8);
        this.toppingsIng.put("Cheese",1.1);
        this.toppingsIng.put("Sauce",0.9);
    }

    private void containTopping() {
        if(!this.toppingsIng.containsKey(this.currentTopping)) {
            throw new IllegalArgumentException("Cannot place " + currentTopping + " on top of your pizza.");
        }
    }
    private void weightUnder50() {
        double currentWeightInGrams = this.weightInGrams;
        if(currentWeightInGrams <= 0 || currentWeightInGrams > 50) {
            throw new IllegalArgumentException(this.currentTopping + " weight should be in the range [1..50].");
        }
    }
    public double calculateToppings() {
        return this.weightInGrams * this.toppingsIng.get(currentTopping) * 2;
    }

}

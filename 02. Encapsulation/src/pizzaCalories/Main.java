package pizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] pizzaArgs = reader.readLine().split(" ");
        String[] doughArgs = reader.readLine().split(" ");

        try {
            Pizza pizza = new Pizza(pizzaArgs[1], Integer.parseInt(pizzaArgs[2]));
            Doughs dough = new Doughs(doughArgs[1],doughArgs[2],Integer.parseInt(doughArgs[3]));
            double pizzaCalories = dough.calculatingDoughsCalories();
            pizza.addDough(dough);
            for (int i = 0; i < Integer.parseInt(pizzaArgs[2]); i++) {
                String[] toppingsArgs = reader.readLine().split(" ");

                Toppings toppings = new Toppings(toppingsArgs[1],Integer.parseInt(toppingsArgs[2]));
                pizzaCalories += toppings.calculateToppings();
                pizza.addTopping(toppings);
            }

            System.out.println(pizzaArgs[1] + " - " + String.format("%.2f",pizzaCalories));
        }
        catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

    }
}

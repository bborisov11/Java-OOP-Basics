package wildFarm.animal;

import wildFarm.food.Food;
import wildFarm.food.Vegetable;

import java.text.DecimalFormat;

public class Zebra extends Mammal {

    public static final String ZEBRAS_ARE_NOT_EATING_THAT_TYPE_OF_FOOD = "Zebras are not eating that type of food!";

    public Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, 0, livingRegion);
    }

    public void setFood(int foodEaten) {
        this.setFoodEaten(foodEaten);
    }
    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Vegetable) {
            this.setFood(food.getQunatity());
        }
        else {
            throw new IllegalArgumentException(ZEBRAS_ARE_NOT_EATING_THAT_TYPE_OF_FOOD);
        }
    }

    @Override
    public String toString() {
        StringBuilder zebra = new StringBuilder();
        DecimalFormat df = new DecimalFormat("##.##");
        zebra.append("Zebra[").append(this.getAnimalName()).append(", ")
                .append(df.format(this.getAnimalWeight())).append(", ")
                .append(this.getLivingRegion()).append(", ")
                .append(this.getFoodEaten()).append("]");
        return zebra.toString();
    }
}

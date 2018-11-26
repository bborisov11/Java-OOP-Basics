package wildFarm.animal;

import wildFarm.food.Food;
import wildFarm.food.Vegetable;

import java.text.DecimalFormat;

public class Mouse extends Mammal {

    public static final String MICE_ARE_NOT_EATING_THAT_TYPE_OF_FOOD = "Mice are not eating that type of food!";

    public Mouse(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, 0, livingRegion);
    }

    public void setFood(int foodEaten) {
        this.setFoodEaten(foodEaten);
    }
    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Vegetable) {
            this.setFood(food.getQunatity());
        }
        else {
            throw new IllegalArgumentException(MICE_ARE_NOT_EATING_THAT_TYPE_OF_FOOD);
        }
    }

    @Override
    public String toString() {
        StringBuilder mouse = new StringBuilder();
        DecimalFormat df = new DecimalFormat("##.##");
        mouse.append("Mouse[").append(this.getAnimalName()).append(", ")
                .append(df.format(this.getAnimalWeight())).append(", ")
                .append(this.getLivingRegion()).append(", ")
                .append(this.getFoodEaten()).append("]");
        return mouse.toString();
    }
}

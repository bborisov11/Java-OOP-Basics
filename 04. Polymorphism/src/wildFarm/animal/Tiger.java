package wildFarm.animal;

import wildFarm.food.Food;
import wildFarm.food.Meat;

import java.text.DecimalFormat;

public class Tiger extends Felime{
    public static final String TIGERS_ARE_NOT_EATING_THAT_TYPE_OF_FOOD = "Tigers are not eating that type of food!";
    private String livingRegion;

    public Tiger(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, 0, livingRegion);
    }

    public void setFood(int foodEaten) {
        this.setFoodEaten(foodEaten);
    }
    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Meat) {
            this.setFood(food.getQunatity());
        }
        else {
            throw new IllegalArgumentException(TIGERS_ARE_NOT_EATING_THAT_TYPE_OF_FOOD);
        }
    }

    @Override
    public String toString() {
        StringBuilder tiger = new StringBuilder();
        DecimalFormat df = new DecimalFormat("##.##");
        tiger.append("Tiger[").append(this.getAnimalName()).append(", ")
                .append(df.format(this.getAnimalWeight())).append(", ")
                .append(this.getLivingRegion()).append(", ")
                .append(this.getFoodEaten()).append("]");
        return tiger.toString();
    }
}

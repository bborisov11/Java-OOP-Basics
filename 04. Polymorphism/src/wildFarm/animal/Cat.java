package wildFarm.animal;

import wildFarm.food.Food;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, 0, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }


    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
       // this.setFood(food.getQunatity());
        //this.setFoodEaten(food.getQunatity() + this.getFoodEaten());
        this.setFoodEaten(food.getQunatity());
    }

    @Override
    public String toString() {
        StringBuilder cat = new StringBuilder();
        DecimalFormat df = new DecimalFormat("##.##");
        cat.append("Cat[").append(this.getAnimalName()).append(", ")
                .append(this.getBreed()).append(", ").append(df.format(this.getAnimalWeight()))
                .append(", ").append(this.getLivingRegion()).append(", ").append(this.getFoodEaten())
                .append("]");
        return cat.toString();
    }
}

package wildFarm;

import wildFarm.animal.*;
import wildFarm.food.Food;
import wildFarm.food.Meat;
import wildFarm.food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        Animal currentAnimal = new Cat("","",0,"","");
        int counter = 0;
        List<Animal> animals = new ArrayList<>();
        while(!(input = reader.readLine()).equals("End")) {
            String[] inputArgs = input.split(" ");
            if(counter % 2 == 0) {
                counter++;
                String animalType = inputArgs[0];
                String animalName = inputArgs[1];
                switch (animalType) {
                    case "Mouse":
                        double mouseWeight = Double.parseDouble(inputArgs[2]);
                        String livingRegion = inputArgs[3];
                        currentAnimal = new Mouse(animalName, animalType, mouseWeight, livingRegion);
                        animals.add(currentAnimal);
                        break;
                    case "Cat":
                        double catWeight = Double.parseDouble(inputArgs[2]);
                        livingRegion = inputArgs[3];
                        String breed = inputArgs[4];
                        currentAnimal = new Cat(animalName, animalType, catWeight, livingRegion, breed);
                        animals.add(currentAnimal);
                        break;
                    case "Tiger":
                        double tigerWeight = Double.parseDouble(inputArgs[2]);
                        livingRegion = inputArgs[3];
                        currentAnimal = new Tiger(animalName, animalType, tigerWeight, livingRegion);
                        animals.add(currentAnimal);
                        break;
                    case "Zebra":
                        double zebraWeight = Double.parseDouble(inputArgs[2]);
                        livingRegion = inputArgs[3];
                        currentAnimal = new Zebra(animalName, animalType, zebraWeight, livingRegion);
                        animals.add(currentAnimal);
                        break;
                }
            }
            else {
                counter++;
                Food food;
                String foodType = inputArgs[0];
                int quantity = Integer.parseInt(inputArgs[1]);

                if(foodType.equals("Vegetable")) {
                    food = new Vegetable(quantity);
                   eatFood(food,currentAnimal);
                }
                else {
                    food = new Meat(quantity);
                    eatFood(food,currentAnimal);
                }
            }
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
    public static void eatFood(Food food, Animal currentAnimal) {
        try {
            currentAnimal.eat(food);
            currentAnimal.makeSound();
        }
        catch (IllegalArgumentException iae) {
            currentAnimal.makeSound();
            System.out.println(iae.getMessage());
        }
    }
}

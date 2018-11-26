package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        List<Animal> animals = new ArrayList<>();
        while(!"Beast!".equals(input = reader.readLine())) {
            String[] animalInput = reader.readLine().split(" ");
            try {
                switch (input) {
                    case "Animal":
                        Animal animal = new Animal(animalInput[0], Integer.parseInt(animalInput[1]), animalInput[2]);
                        animals.add(animal);
                        break;
                    case "Dog":
                         animal = new Dog(animalInput[0], Integer.parseInt(animalInput[1]), animalInput[2]);
                        animals.add(animal);
                        break;
                    case "Frog":
                        animal = new Frog(animalInput[0], Integer.parseInt(animalInput[1]), animalInput[2]);
                        animals.add(animal);
                        break;
                    case "Cat":
                        animal = new Cat(animalInput[0], Integer.parseInt(animalInput[1]), animalInput[2]);
                        animals.add(animal);
                        break;
                    case "Tomcat":
                        Cat cat = new Tomcat(animalInput[0], Integer.parseInt(animalInput[1]), animalInput[2]);
                        animals.add(cat);
                        break;
                    case "Kitten":
                         cat = new Kitten(animalInput[0], Integer.parseInt(animalInput[1]), animalInput[2]);
                        animals.add(cat);
                }

            }
            catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
        for (Animal animal : animals) {
            System.out.println(animal.getClass().getSimpleName());
            System.out.println(animal.toString());
            animal.produceSound();
        }

    }
}

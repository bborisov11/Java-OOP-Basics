package catLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        Cat cat = new Cat();
        Map<String, Cat> map = new HashMap<>();
        while (!"End".equals(input = reader.readLine())) {
            String[] commandArgs = input.split(" ");

            String typeOfCat = commandArgs[0];
            String nameOfCat = commandArgs[1];

            switch (typeOfCat) {

                case "StreetExtraordinaire":
                    double decibelsOfMeows = Double.parseDouble(commandArgs[2]);
                    Cat streetExtraordinaire = new StreetExtraordinaire(nameOfCat, decibelsOfMeows);
                    map.put(nameOfCat, streetExtraordinaire);
                    break;
                case "Cymric":
                    double furLength = Double.parseDouble(commandArgs[2]);
                    Cat cymric = new Cymric(nameOfCat, furLength);
                    map.put(nameOfCat, cymric);
                    break;
                case "Siamese":
                    int earSize = Integer.parseInt(commandArgs[2]);
                    Cat siamese = new Siamese(nameOfCat, earSize);
                    map.put(nameOfCat, siamese);
                    break;
            }
        }
        String catName = reader.readLine();
        System.out.println(map.get(catName).toString());
    }
}

package shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] allPeople = reader.readLine().split("[=;]+");
        Map<String,Person> mapOfPerson = new LinkedHashMap<>();
        Map<String,Product> mapOfProducts = new LinkedHashMap<>();
        for (int i=0; i< allPeople.length - 1; i += 2) {
            try {
                mapOfPerson.putIfAbsent(allPeople[i], new Person(allPeople[i], Double.parseDouble(allPeople[i + 1]), new ArrayList<>()));
            }
            catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                return;
            }
        }
        String[] allProducts = reader.readLine().split("[=;]+");
        for (int i = 0; i < allProducts.length - 1; i += 2) {
            try {
            mapOfProducts.putIfAbsent(allProducts[i],new Product(allProducts[i],Double.parseDouble(allProducts[i+1])));
            }
            catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                return;
            }
        }
        String input = "";

        while(!"END".equals((input = reader.readLine()))) {
            String [] arg = input.split(" ");
            String personName = arg[0];
            String productName = arg[1];

            Person currentPerson = mapOfPerson.get(personName);
            Product currentProduct = mapOfProducts.get(productName);

            if(mapOfPerson.containsKey(personName) && mapOfProducts.containsKey(productName)) {
                if(currentPerson.tryBuyProduct(currentProduct.getCost())) {
                    System.out.println(personName + " bought " + productName);
                    currentPerson.addProduct(mapOfProducts.get(productName));
                }
                else {
                    System.out.println(personName + " can't afford " + productName);
                }
            }
        }

        mapOfPerson.entrySet().stream().map(Map.Entry::getValue).forEach(Person::printOutput);
    }
}

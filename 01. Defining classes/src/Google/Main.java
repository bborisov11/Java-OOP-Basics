package Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> personMap = new TreeMap<>();

        String arg;
        while (!(arg = reader.readLine()).equals("End")) {

            String[] commandArgs = arg.split(" ");
            String personName = commandArgs[0];

            if (!personMap.containsKey(personName)) {
                Person person = fillPerson(commandArgs, new Person());
                person.setPersonName(personName);
                personMap.put(personName, person);
            } else {
                fillPerson(commandArgs, personMap.get(personName));
            }
        }
        String name = reader.readLine();
        System.out.println(personMap.get(name).toString());

    }

    private static Person fillPerson(String[] commandArgs, Person person) {

        switch (commandArgs[1]) {
            case "company":
                Person.Company company = person.new Company(commandArgs[2], commandArgs[3], commandArgs[4]);
                person.setCompany(company);
                break;
            case "pokemon":
                Person.Pokemon pokemon = person.new Pokemon(commandArgs[2], commandArgs[3]);
                person.getPokemons().add(pokemon);
                break;
            case "parents":
                Person.Parent parent = person.new Parent(commandArgs[2], commandArgs[3]);
                person.getParents().add(parent);
                break;
            case "children":
                Person.Child child = person.new Child(commandArgs[2], commandArgs[3]);
                person.getChildren().add(child);
                break;
            case "car":
                Person.Car car = person.new Car(commandArgs[2], Integer.parseInt(commandArgs[3]));
                person.setCar(car);
                break;
        }
        return person;
    }
}

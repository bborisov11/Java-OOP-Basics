package Google;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Person {

    private String personName;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;


    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public Person() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    class Company {
        private String companyName;
        private String department;
        private String salary;

         public Company(String companyName, String department, String salary) {
             this.companyName = companyName;
             this.department = department;
             this.salary = salary;
         }
    }
     class Pokemon {
        private String pokemonName;
        private String pokemonType;

         public Pokemon(String pokemonName, String pokemonType) {
             this.pokemonName = pokemonName;
             this.pokemonType = pokemonType;
         }

     }
     class Parent {
        private String parentName;
        private String parentBirthday;

         public Parent(String parentName, String parentBirthday) {
             this.parentName = parentName;
             this.parentBirthday = parentBirthday;
         }
     }
     class Child {
        private String childName;
        private String childBirthday;

         public Child(String childName, String childBirthday) {
             this.childName = childName;
             this.childBirthday = childBirthday;
         }
     }
     class Car {
        private String carModel;
        private int carSpeed;

         public Car(String carModel, int carSpeed) {
             this.carModel = carModel;
             this.carSpeed = carSpeed;
         }
     }
    @Override
    public String toString() {

        //first way
          StringBuilder pokemonBuilder = new StringBuilder();
          for (Pokemon pokemon : pokemons) {
              pokemonBuilder.append(pokemon.pokemonName).append(" ").append(pokemon.pokemonType).append(System.getProperty("line.separator"));
          }
          StringBuilder parentsBuilder = new StringBuilder();
          for (Parent parent : parents) {
              parentsBuilder.append(parent.parentName).append(" ").append(parent.parentBirthday).append(System.getProperty("line.separator"));
          }
          StringBuilder childrenBuilder = new StringBuilder();
          for (Child child : children) {
              childrenBuilder.append(child.childName).append(" ").append(child.childBirthday).append(System.getProperty("line.separator"));
          }

        //second
          // String pokemonBuilder =  String.join("",pokemons.stream()
          //         .map(x -> x.pokemonName + " " + x.pokemonType +System.getProperty("line.separator")).collect(Collectors.toList()));
          // String parentsBuilder =  String.join("",parents.stream()
          //         .map(x -> x.parentName + " " + x.parentBirthday + System.getProperty("line.separator")).collect(Collectors.toList()));
          // String childrenBuilder =  String.join("",children.stream()
          //         .map(x -> x.childName + " " + x.childBirthday + System.getProperty("line.separator")).collect(Collectors.toList()));

        //third
          // String pokemonBuilder = pokemons.stream().map(x -> x.pokemonName + " " + x.pokemonType +System.getProperty("line.separator")).collect(Collectors.joining());
          // String parentsBuilder = parents.stream().map(x -> x.parentName + " " + x.parentBirthday +System.getProperty("line.separator")).collect(Collectors.joining());
          // String childrenBuilder = children.stream().map(x -> x.childName + " " + x.childBirthday +System.getProperty("line.separator")).collect(Collectors.joining());

        return   personName + '\n' +
                 "Company:"+ '\n'+
                (company != null ? company.companyName + " " + company.department + " " + String.format("%.2f",Double.parseDouble(company.salary))+'\n': "") +
                "Car:" + '\n' +
                (car != null ? car.carModel + " " + car.carSpeed + '\n': "") +
                "Pokemon:" + '\n'+
                pokemonBuilder
                 + "Parents:" + '\n' +
                 parentsBuilder  +
                 "Children:" + '\n' +
                childrenBuilder;
    }
}

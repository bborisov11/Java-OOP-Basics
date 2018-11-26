package shoppingSpree;

import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;


    public Person(String name, double money, List<Product> products) {
       setName(name);
       setMoney(money);
        this.products = products;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if(money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }
    public boolean tryBuyProduct(double price) {
            if(this.money >= price) {
                this.money -= price;
                return true;
            }
        return false;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void printOutput() {
        if(products.size() == 0) {
            System.out.println(this.name + " - Nothing bought");
        }
        else {
            String output = String.join(", ",this.products.stream().map(Product::getName).collect(Collectors.toList()));
            System.out.println(this.name + " - " + output);
        }
    }
}

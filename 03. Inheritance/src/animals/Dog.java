package animals;

public class Dog extends Animal {
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    public void produceSound() {
        System.out.println("BauBau");
    }
    //@Override
    public String toString() {
        return this.getName() + " " + this.getAge() + " " + this.getGender();
    }
}

package animals;

public class Frog extends Animal {
    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    public void produceSound() {
        System.out.println("Frogggg");
    }

    public String toString() {
        return this.getName() + " " + this.getAge() + " " + this.getGender();
    }
}

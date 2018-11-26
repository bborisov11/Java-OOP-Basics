package animals;

public class Kitten extends Cat{

    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
    //    this.setGender(gender);
    }

 //   public void setGender(String gender) {
 //       if(this.getGender().equals("Male")) {
 //           throw new IllegalArgumentException("Invalid input!");
 //       }
 //   }

    public void produceSound() {
        System.out.println("Miau");
    }

    public String toString() {
        return this.getName() + " " + this.getAge() + " " + this.getGender();
    }
}

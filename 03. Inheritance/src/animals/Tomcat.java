package animals;

public class Tomcat extends Cat {

    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    //    this.setGender(gender);
    }


   // public void setGender(String gender) {
   //     if(this.getGender().equals("Female")) {
   //         throw new IllegalArgumentException("Invalid input!");
   //     }
   // }


    public void produceSound() {
        System.out.println("Give me one million b***h");
    }

    public String toString() {
        return this.getName() + " " + this.getAge() + " " + this.getGender();
    }
}

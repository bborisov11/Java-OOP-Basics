package Colonists;

public class Surgeon extends Medic {
    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int currentPotential = super.getPotential();
        if(this.getAge() > 25 && this.getAge() < 35) {
            this.grow(2);
            currentPotential += 2;
        }
        if(this.getSign().equals("precise")) {
            currentPotential += 3;
        }
        else if(this.getSign().equals("butcher")) {
            currentPotential -= 3;
        }
        return  currentPotential;
    }

    @Override
    public void grow(int years) {
        super.setAge(this.getAge() + years);
    }
}

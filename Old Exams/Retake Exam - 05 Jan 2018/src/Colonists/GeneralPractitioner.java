package Colonists;

public class GeneralPractitioner extends Medic {
    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int currentPotential = super.getPotential();
        if(this.getAge() > 15) {
            currentPotential += 1;
        }
        if(this.getSign().equals("caring")) {
            currentPotential += 1;
        }
        else if(this.getSign().equals("careless")) {
            currentPotential -= 2;
        }
        return  currentPotential;
    }

    @Override
    public void grow(int years) {

    }
}

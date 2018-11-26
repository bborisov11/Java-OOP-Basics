package Colonists;

public class Soldier extends Colonist {
    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
        this.grow(3);
    }

    @Override
    public int getPotential() {
        return 6 + this.getTalent();
    }
    @Override
    public void grow(int years) {
        super.setAge(this.getAge() + years);
    }
}

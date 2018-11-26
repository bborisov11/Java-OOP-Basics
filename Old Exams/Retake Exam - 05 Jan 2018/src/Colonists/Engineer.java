package Colonists;

public abstract class Engineer extends Colonist {
    public Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
        this.setAge(age);
    }

    @Override
    public void grow(int years) {
        super.setAge(this.getAge() + years);
    }

    @Override
    public void setAge(int age) {
        if(super.getAge() > 30) {
            this.grow(2);
        }
    }

    @Override
    public int getPotential() {
        if(this.getAge() > 30) {
            return 5 + this.getTalent();
        }
        else {
            return 3 + this.getTalent();
        }
    }
}

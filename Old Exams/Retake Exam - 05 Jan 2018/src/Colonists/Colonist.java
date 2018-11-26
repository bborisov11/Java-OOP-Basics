package Colonists;

public abstract class Colonist {
    private String id;
    private String familyId;
    private int talent;
    private int age;

    public Colonist(String id, String familyId, int talent, int age) {
        this.id = id;
        this.familyId = familyId;
        this.talent = talent;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getFamilyId() {
        return familyId;
    }

    public int getTalent() {
        return talent;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract int getPotential();
    public abstract void grow(int years);
}

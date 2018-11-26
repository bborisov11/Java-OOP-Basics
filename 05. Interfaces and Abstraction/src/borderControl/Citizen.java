package borderControl;

public class Citizen implements BorderControl{
    private String name;
    private int age;
    private String id;

    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public boolean fakeIds(String id) {
        if(this.id.endsWith(id)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.id;
    }
}

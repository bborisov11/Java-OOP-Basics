package avatar.monuments;

public abstract class BaseMonuments {

    private String name;

    public BaseMonuments(String name) {
        this.name = name;
    }

    public abstract int getAffinity();

    @Override
    public String toString() {
        return this.name;
    }
}

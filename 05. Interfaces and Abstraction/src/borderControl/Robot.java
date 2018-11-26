package borderControl;

public class Robot implements BorderControl{
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
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

package birthdayCelebrations;

public class Pet implements BirthDate {
    private String name;
    private String birthdate;

    public Pet(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public boolean getBirthDate(String date) {
        if(this.birthdate.endsWith(date)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.birthdate;
    }
}

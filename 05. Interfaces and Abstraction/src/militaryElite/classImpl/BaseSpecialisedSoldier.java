package militaryElite.classImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseSpecialisedSoldier extends PrivateImpl {

    private String corps;
    private List<String> corpsType = new ArrayList<String>() {{
       add("Airforces");
       add("Marines");
    }};

    public BaseSpecialisedSoldier(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
       this.setCorps(corps);
    }

    public void setCorps(String corps) {
        if(!this.corpsType.contains(corps)) {
            throw new IllegalArgumentException();
        }
        this.corps = corps;
    }

    public List<String> getCorpsType() {
        return Collections.unmodifiableList(this.corpsType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator()).append("Corps: ").append(this.corps);
        return sb.toString();
    }
}

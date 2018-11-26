import Colonists.Colonist;
import java.util.HashMap;
import java.util.Map;

public class Family {
    private String id;
    private Map<String,Colonist> colonists;

    public Family(String id) {
        this.id = id;
        this.colonists = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public Map<String, Colonist> getColonists() {
        return colonists;
    }
}

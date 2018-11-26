package militaryElite.classImpl;

import militaryElite.interfaces.Mission;

import java.util.ArrayList;
import java.util.List;

public class MissionImpl implements Mission {
    private String codeName;
    private List<String> state = new ArrayList<String>(){{
        add("inProgress");
        add("Finished");
    }};
    private String currentState;

    public MissionImpl(String codeName, String currentState) {
        this.codeName = codeName;
        this.completeMission(currentState);
    }
    public boolean completeMission(String currentState) {
        if(state.contains(currentState)) {
            this.currentState = currentState;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder mission = new StringBuilder();
        mission.append("Code Name: ").append(this.codeName).append(" State: ").append(this.currentState);
        return mission.toString();
    }
}

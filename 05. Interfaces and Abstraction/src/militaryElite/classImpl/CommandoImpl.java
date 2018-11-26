package militaryElite.classImpl;

import militaryElite.interfaces.Commando;
import militaryElite.interfaces.Mission;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class CommandoImpl extends BaseSpecialisedSoldier implements Commando {

    private HashSet<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String currentCorps) {
        super(id, firstName, lastName, salary, currentCorps);
        this.missions = new LinkedHashSet<>();
    }

    public HashSet<Mission> getMissions() {
        return missions;
    }

    @Override
    public String toString() {
        StringBuilder commando = new StringBuilder();
        commando.append(super.toString()).append(System.lineSeparator()).append("Missions:")
                .append(this.missions.size() != 0 ? '\n' : "");

        for (Mission mission : missions) {
            commando.append(mission.toString()).append(System.lineSeparator());
        }
        return commando.toString();
    }
}

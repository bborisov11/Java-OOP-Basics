package militaryElite.interfaces;

import java.util.HashSet;

public interface Commando extends Soldier {
    HashSet<Mission> getMissions();
}

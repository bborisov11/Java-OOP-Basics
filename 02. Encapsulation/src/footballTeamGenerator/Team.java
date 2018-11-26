package footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private double rating;
    private List<Player> players;

    public Team() {
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public double getRating() {
        if(this.players.size() == 0) {
            return 0;
        }
        return this.players.stream().mapToDouble(Player::getStats).sum();
    }


    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public boolean containPlayer(String name) {
        if(this.players.stream().noneMatch(x -> name.equals(x.getName()))) {
            throw new IllegalArgumentException("Player "+ name +" is not in "+ this.name +" team. ");
        }
        return true;
    }
    public void removePlayer(String name) {
        Player player = players.stream().filter(x -> name.equals(x.getName())).findFirst().get();
        players.remove(player);
    }
}

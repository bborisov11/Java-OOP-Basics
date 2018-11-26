package footballTeamGenerator;

public class Player {
    private String name;
    private Stats stats;


    public Player(String name, Stats stats) {
        this.setName(name);
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public double getStats() {
        return (stats.getDribble() + stats.getEndurance() + stats.getPassing() + stats.getSprint() + stats.getShooting()) / 5.0;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }
}

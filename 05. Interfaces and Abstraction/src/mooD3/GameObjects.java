package mooD3;

public abstract class GameObjects {
    private String username;
    private String hashedPassword;
    private int level;
    private double specialPoints;

    public GameObjects(String username, String hashedPassword, int level, double specialPoints) {
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.level = level;
        this.specialPoints = specialPoints;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public int getLevel() {
        return level;
    }

    public double getSpecialPoints() {
        return specialPoints;
    }

    @Override
    public String toString() {
        return "\"" + this.username + "\"" + " | " ;
    }
}

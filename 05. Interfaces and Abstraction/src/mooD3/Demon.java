package mooD3;

public class Demon extends GameObjects implements Functionality{

    private String hashedPassword;

    public Demon(String username, int level, double specialPoints) {
        super(username, "", level, specialPoints);
    }

    @Override
    public String hashedPassword(String username) {
        String hashedPassword = username.length() * 217 + "";
        this.setHashedPassword(hashedPassword);
        this.hashedPassword = hashedPassword;
        return  hashedPassword;
    }


    @Override
    public String toString() {
        return super.toString() + "\"" + this.hashedPassword + "\"" + " -> Demon" + '\n' +
                this.getSpecialPoints() * this.getLevel();
    }
}

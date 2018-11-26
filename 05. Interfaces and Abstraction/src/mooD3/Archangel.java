package mooD3;

public class Archangel extends GameObjects implements Functionality {
    private String hashedPassword;
    public Archangel(String username, int level, double specialPoints) {
        super(username, "", level, specialPoints);
    }

    @Override
    public String hashedPassword(String username) {
        String hashedPassword = new StringBuilder(username).reverse().toString() + username.length() * 21 + "";
        this.setHashedPassword(hashedPassword);
        this.hashedPassword = hashedPassword;
        return hashedPassword;
    }

    @Override
    public String toString() {
        return super.toString() + "\"" + this.hashedPassword + "\"" + " -> Archangel" + '\n' +
                (int)this.getSpecialPoints() * this.getLevel();
    }
}

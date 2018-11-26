package Impl.heroes;

public class DCHero extends Hero {
    public DCHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }

    @Override
    public double attack() {
        return this.getEnergy()/1.5 + this.getSpecial() + this.getIntelligence();
    }

    @Override
    public String toString() {
        return super.toString() + "####DC Attack Power: " + this.attack();
    }
}

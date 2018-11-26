package Impl.antiHeroes;

public class Titan extends AntiHero{

    public Titan(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        return (this.getEnergy() + this.getIntelligence() + this.getSpecial()) * 3;
    }

    @Override
    public String toString() {
        return super.toString() + "####Titan Attack Power: " + this.attack();
    }
}

package Impl.antiHeroes;

public class Villain extends AntiHero{

    public Villain(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        return (this.getIntelligence() * this.getSpecial()) / this.getEnergy();
    }

    @Override
    public String toString() {
        return super.toString() + "####Villain Attack Power: " + this.attack();
    }
}

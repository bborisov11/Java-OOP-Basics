package Impl.antiHeroes;

import Impl.ComicCharacterImpl;
import interfaces.SuperPower;

public class AntiHero extends ComicCharacterImpl {
    private double evilness;

    public AntiHero(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence);
        this.evilness = evilness;
    }

    public double getEvilness() {
        return evilness;
    }

    public void setEvilness(double evilness) {
        if(evilness <= 0) {
            throw new IllegalArgumentException("Evilness should be a possitive number!");
        }
        this.evilness = evilness;
    }

    @Override
    public double getSpecial() {
        return this.evilness;
    }

    @Override
    public String toString() {
        return super.toString() + '\n' + "###Evilness: " + this.getSpecial() + '\n';
    }
}

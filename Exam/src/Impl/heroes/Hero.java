package Impl.heroes;

import Impl.ComicCharacterImpl;

public abstract class Hero extends ComicCharacterImpl {
    private double heroism;

    public Hero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence);
        this.heroism = heroism;
    }

    public double getHeroism() {
        return heroism;
    }

    public void setHeroism(double heroism) {
        if(heroism <= 0) {
            throw new IllegalArgumentException("Heroism should be a possitive number!");
        }
        this.heroism = heroism;
    }

    @Override
    public double getSpecial() {
        return this.heroism;
    }

    @Override
    public String toString() {
        return super.toString() + '\n' + "###Heroism: " + this.getSpecial();
    }
}

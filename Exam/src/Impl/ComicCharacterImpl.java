package Impl;


import Impl.heroes.Hero;
import interfaces.ComicCharacter;
import interfaces.SuperPower;

import java.util.ArrayList;
import java.util.List;

public class ComicCharacterImpl implements ComicCharacter{
    private String name;
    private int energy;
    private double health;
    private double intelligence;
    private List<SuperPower> superPowers;

    public ComicCharacterImpl(String name, int energy, double health, double intelligence) {
        this.setName(name);
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
        this.superPowers = new ArrayList<>();
    }

    @Override
    public double attack() {
        return 0;
    }

    @Override
    public double getSpecial() {
        return 0;
    }

    @Override
    public String useSuperPowers() {
        if(this.superPowers.size() == 0) {
            return  " has no super powers!";
        }
        else {
            return " used his super powers!";
        }
    }

    @Override
    public void addSuperPower(SuperPower superPower) {
        this.superPowers.add(superPower);
    }

    @Override
    public void takeDamage(double damage) {

    }

    public String getName() {
        return name;
    }

    @Override
    public void boostCharacter(int energy, double health, double intelligence) {

    }

    private void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    private void setEnergy(int energy) {
        if(energy > 300) {
        throw new IllegalArgumentException("Energy is not in the correct range!");
        }
        this.energy = energy;
    }

    public double getHealth() {
        return health;
    }

    private void setHealth(double health) {
        if(health <= 0) {
            throw new IllegalArgumentException("Health should be a possitive number!");
        }
        this.health = health;
    }

    public double getIntelligence() {
        return intelligence;
    }



    private void setIntelligence(double intelligence) {
        if(intelligence <= 0) {
            throw new IllegalArgumentException("Intelligence is not in the correct range!");
        }
        this.intelligence = intelligence;
    }

    public List<SuperPower> getSuperPowers() {
        return superPowers;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("#Name: ").append(this.name).append(System.lineSeparator())
                .append("##Health: ").append(String.format("%.2f",this.health)).append("//").append("Energy: ").append(this.energy)
                .append("//").append("Intelligence: ").append(this.intelligence);
        return builder.toString();
    }
}

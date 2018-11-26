package Impl;

import Impl.antiHeroes.AntiHero;
import Impl.heroes.Hero;
import interfaces.Arena;
import interfaces.ComicCharacter;

import java.util.ArrayList;
import java.util.List;

public class ArenaImpl implements Arena {
    private String arenaName;
    private List<ComicCharacter> heroes;
    private List<ComicCharacter> antiHeroes;
    private int capacity;

    public ArenaImpl(String arenaName, int capacity) {
        this.arenaName = arenaName;
        this.capacity = capacity;
        this.heroes = new ArrayList<>();
        this.antiHeroes = new ArrayList<>();
    }

    public List<ComicCharacter> getHeroes() {
        return heroes;
    }

    public List<ComicCharacter> getAntiHeroes() {
        return antiHeroes;
    }

    @Override
    public boolean isArenaFull() {
        if(heroes.size() + antiHeroes.size() >= capacity) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void addHero(ComicCharacter hero) {
        this.heroes.add(hero);
    }

    @Override
    public void addAntiHero(ComicCharacter antiHero) {
        antiHeroes.add(antiHero);
    }

    @Override
    public boolean fightHeroes() {
        return false;
    }
    public String getArenaName() {
        return arenaName;
    }

    public int getCapacity() {
        return capacity;
    }
}

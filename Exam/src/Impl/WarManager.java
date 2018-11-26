package Impl;

import Impl.antiHeroes.AntiHero;
import Impl.heroes.Hero;
import interfaces.Arena;
import interfaces.ComicCharacter;
import interfaces.Manager;
import interfaces.SuperPower;

import java.util.HashMap;
import java.util.Map;

public class WarManager implements Manager {

    private Map<String,ComicCharacter> comicCharacters;
    private Map<String, Arena> arenas;
    private Map<String,SuperPower> superPowers;

    public WarManager() {
        this.comicCharacters = new HashMap<>();
        this.arenas = new HashMap<>();
        this.superPowers = new HashMap<>();
    }

    @Override
    public String checkComicCharacter(String characterName) {
        if(!this.comicCharacters.containsKey(characterName)) {
            throw new IllegalArgumentException("Sorry, fans! " + characterName +" doesn't exist in our comics!");
        }
        else {
            if(this.comicCharacters.get(characterName).getHealth() <= 0) {
                throw new IllegalArgumentException(characterName +" has fallen in battle!");
            }
            StringBuilder builder = new StringBuilder();
            ComicCharacter currentChar = this.comicCharacters.get(characterName);
            builder.append(this.comicCharacters.get(characterName).toString());
            return builder.toString();
        }
    }

    @Override
    public String addHero(ComicCharacter hero) {
        if(!this.comicCharacters.containsKey(hero.getName())) {
            this.comicCharacters.put(hero.getName(), hero);
            return hero.getName() + "is ready for battle!";
        }
        else {
            this.comicCharacters.put(hero.getName(),hero);
           return hero.getName() + "evolved!";
        }
    }

    @Override
    public String addAntiHero(ComicCharacter antiHero) {
        if(!this.comicCharacters.containsKey(antiHero.getName())) {
            this.comicCharacters.put(antiHero.getName(), antiHero);
            return antiHero.getName() + "is ready for destruction!";
        }
        else {
            this.comicCharacters.put(antiHero.getName(),antiHero);
            return antiHero.getName() + "is getting stronger!";
        }
    }

    @Override
    public String addArena(Arena arena) {
        if(!this.arenas.containsKey(arena.getArenaName())) {
            this.arenas.put(arena.getArenaName(), arena);
            return arena.getArenaName() + " is becoming a fighting ground!";
        }
        else {
            return "A battle is about to start there!";
        }
    }

    @Override
    public String addHeroToArena(String arena, String hero) {

            if(this.arenas.get(arena).getHeroes().contains(this.comicCharacters.get(hero))) {
                return hero + " is fighting!";
            }
            if(!this.arenas.get(arena).getHeroes().contains(this.comicCharacters.get(hero))
                    && this.comicCharacters.get(hero).getHealth() <= 0){
                    return hero + " is dead!";
            }
            if(this.arenas.get(arena).isArenaFull()) {
                return "Arena is full!";
            }
            else {
                this.arenas.get(arena).addHero(this.comicCharacters.get(hero));
                return hero + " is fighting for your freedom in " + arena + "!";
            }
    }

    @Override
    public String addAntiHeroToArena(String arena, String antiHero) {
        if(this.arenas.get(arena).getAntiHeroes().contains(this.comicCharacters.get(antiHero))) {
            return antiHero + " is fighting!";
        }
        if(!this.arenas.get(arena).getAntiHeroes().contains(this.comicCharacters.get(antiHero))
                && this.comicCharacters.get(antiHero).getHealth() <= 0){
            return antiHero + " is dead!";
        }
        if(this.arenas.get(arena).isArenaFull()) {
            return "Arena is full!";
        }
        else {
            this.arenas.get(arena).addAntiHero(this.comicCharacters.get(antiHero));
            return antiHero +" and his colleagues are trying to take over " + arena + "!";
        }
    }

    @Override
    public String loadSuperPowerToPool(SuperPower superPower) {
        if (this.comicCharacters.values().stream()
                .anyMatch(x -> x.getSuperPowers().contains(superPower))) {
            throw new IllegalArgumentException("This super power already exists!");
        } else {
            this.comicCharacters.values().forEach(x -> x.getSuperPowers().add(superPower));
            this.superPowers.put(superPower.getName(), superPower);
            return superPower.getName() + " added to pool!";
        }
    }


    @Override
    public String assignSuperPowerToComicCharacter(String comicCharacter, String superPower) {
            if(this.comicCharacters.get(comicCharacter).getSuperPowers().contains(superPowers.get(superPower))) {
                return superPower + " already assigned!";
            }
            else {
                //need to add to superpowerDIct!!!
                if(this.comicCharacters.values().stream()
                        .anyMatch(x -> x.getSuperPowers().stream().anyMatch(y -> y.getName().equals(superPower)))) {
                    throw new IllegalArgumentException("Can't assign it to any other character!");
                }
                this.comicCharacters.get(comicCharacter).addSuperPower(superPowers.get(superPower));
                return comicCharacter + " has a new super power!";
            }
    }

    @Override
    public String usePowers(String characterName) {
       return characterName + this.comicCharacters.get(characterName).useSuperPowers();
    }

    @Override
    public String startBattle(String arena) {
        if(this.arenas.get(arena).getAntiHeroes().size() == 0 && this.arenas.get(arena).getHeroes().size() == 0) {
            return "SAFE ZONE!";
        }
        else if(this.arenas.get(arena).getHeroes().size() == 0) {
            return null;
        }
        return null;
    }

    @Override
    public String endWar() {
        return null;
    }
}

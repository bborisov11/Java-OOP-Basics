package Impl;

import Impl.antiHeroes.Titan;
import Impl.antiHeroes.Villain;
import Impl.heroes.DCHero;
import Impl.heroes.MarvelHero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
            WarManager manager = new WarManager();
        while(!(input = reader.readLine()).equals("WAR_IS_OVER")) {
            String[] inputArgs = input.split(" ");

            switch (inputArgs[0]) {
                case "CHECK_CHARACTER":
                    try {
                        System.out.println(manager.checkComicCharacter(inputArgs[1]));
                    }
                    catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "REGISTER_HERO ":
                    try {
                        String charName = inputArgs[1];
                        String type = inputArgs[2];
                        if (type.equals("MarvelHero")) {
                            System.out.println(manager.addHero(
                                    new MarvelHero(charName, Integer.parseInt(inputArgs[3]), Double.parseDouble(inputArgs[4])
                                    , Double.parseDouble(inputArgs[5]), Double.parseDouble(inputArgs[6]))));
                        } else {
                            System.out.println(manager.addHero(
                                    new DCHero(charName, Integer.parseInt(inputArgs[3]), Double.parseDouble(inputArgs[4])
                                    , Double.parseDouble(inputArgs[5]), Double.parseDouble(inputArgs[6]))));
                        }
                    }
                    catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "REGISTER_ANTI_HERO":
                     String charName = inputArgs[1];
                     String type = inputArgs[2];
                     try {
                         if (type.equals("Villain")) {
                             System.out.println(manager.addAntiHero(
                                     new Villain(charName, Integer.parseInt(inputArgs[3]), Double.parseDouble(inputArgs[4])
                                     , Double.parseDouble(inputArgs[5]), Double.parseDouble(inputArgs[6]))));
                         } else {
                             System.out.println(manager.addAntiHero(
                                     new Titan(charName, Integer.parseInt(inputArgs[3]), Double.parseDouble(inputArgs[4])
                                     , Double.parseDouble(inputArgs[5]), Double.parseDouble(inputArgs[6]))));
                         }
                     }
                     catch (IllegalArgumentException iae) {
                         System.out.println(iae.getMessage());
                     }
                    break;
                case "BUILD_ARENA":
                    try {
                        String arenaName = inputArgs[1];
                        int capacity = Integer.parseInt(inputArgs[2]);
                        System.out.println(manager.addArena(new ArenaImpl(arenaName, capacity)));
                    }
                    catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "SEND_HERO":
                    try {
                       String arenaName = inputArgs[1];
                        String heroName = inputArgs[2];
                        System.out.println(manager.addHeroToArena(arenaName, heroName));
                    }
                    catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "SEND_ANTI_HERO":
                    try {
                        String arenaName = inputArgs[1];
                        String antiHeroName = inputArgs[2];
                        System.out.println(manager.addAntiHeroToArena(arenaName, antiHeroName));
                    }
                    catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "SUPER_POWER":
                    try {
                        String superPowerName = inputArgs[1];
                        double powerPoints = Double.parseDouble(inputArgs[2]);
                        System.out.println(manager.loadSuperPowerToPool(new Power(superPowerName, powerPoints)));
                    }
                    catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "ASSIGN_POWER":
                    try {
                        String comicName = inputArgs[1];
                        String superPowerName = inputArgs[2];
                        System.out.println(manager.assignSuperPowerToComicCharacter(comicName, superPowerName));
                    }
                    catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "UNLEASH":
                    try {
                       String comicName = inputArgs[1];
                        System.out.println(manager.usePowers(comicName));
                    }
                    catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "COMICS_WAR":
                    try {
                        String arenaName = inputArgs[1];
                        System.out.println(manager.startBattle(arenaName));
                    }
                    catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
            }
        }
    }
}

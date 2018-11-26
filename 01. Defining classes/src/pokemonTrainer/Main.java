package pokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Trainer> trainers = new ArrayList<>();
        String input;
        Trainer trainer;
        while(!(input = reader.readLine()).equals("Tournament")) {
            String[] commands = input.split(" ");
            String trainerName = commands[0];
            String pokemonName = commands[1];
            String pokemonElement = commands[2];
            int pokemonHealth = Integer.parseInt(commands[3]);

            if(trainers.stream().noneMatch(x -> x.getName().equals(trainerName))) {
                 trainer = new Trainer(trainerName, new ArrayList<>());
                trainer.getPokemons().add(new Pokemon(pokemonName,pokemonElement,pokemonHealth));
                trainers.add(trainer);
            }
            else {
                Trainer currentTrainer = trainers.stream().filter(x -> x.getName().equals(trainerName)).findFirst().get();
                currentTrainer.getPokemons().add(new Pokemon(pokemonName,pokemonElement,pokemonHealth));
            }
        }
        String command;

        while(!(command = reader.readLine()).equals("End")) {
            final String comand = command;
            //boolean containsElement = trainers.stream().anyMatch(x -> x.getPokemons().stream().anyMatch(y -> y.getElement().equals(comand)));
           // if(containsElement) {
              //  trainers.stream()
              //          .filter(x -> x.getPokemons().stream().anyMatch(z -> z.getElement().equals(command)))
              //          .forEach(x -> x.setNumberOfBadges(5));
            for (Trainer trainer1 : trainers) {
                if (trainer1.getPokemons().stream().anyMatch(x -> x.getElement().equals(comand))) {
                    int currentNum = trainer1.getNumberOfBadges() + 1;
                    trainer1.setNumberOfBadges(currentNum);
                } else {
                    // trainer1.getPokemons().stream().map(x -> x.setHealth(x.getHealth() - 10))
                    Iterator<Pokemon> pokemons = trainer1.getPokemons().iterator();
                    while(pokemons.hasNext()) {
                        Pokemon currentPokemon = pokemons.next();
                        currentPokemon.setHealth(currentPokemon.getHealth() - 10);
                        if(currentPokemon.getHealth() <= 0) {
                            pokemons.remove();
                        }
                    }
                }
            }
        }

        trainers
                .stream()
                .sorted(Comparator.comparing(Trainer::getNumberOfBadges,Comparator.reverseOrder()))
                    .forEach(x -> System.out.println(x.getName() + " " + x.getNumberOfBadges() + " " + x.getPokemons().size()));

    }
}

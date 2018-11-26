package footballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> teams = new LinkedHashMap<>();

        String input = "";
        while (!"END".equals(input = reader.readLine())) {
            String[] commandArgs = input.split(";");
            String command = commandArgs[0];

            String playerName;
            switch (command) {
                case "Team":
                    try {
                        try {
                            String teamName = commandArgs[1];
                            Team team = new Team();
                            team.setName(commandArgs[1]);
                            teams.putIfAbsent(teamName, team);
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException aiobe) {
                        System.out.println("A name should not be empty.");
                    }
                    break;
                case "Add":
                    String teamName = commandArgs[1];
                        if(!teams.containsKey(teamName)) {
                            System.out.println("Team " + teamName + " does not exist.");
                            continue;
                        }
                        try {
                             playerName = commandArgs[2];

                            int endurance = Integer.parseInt(commandArgs[3]);
                            int sprint = Integer.parseInt(commandArgs[4]);
                            int dribble = Integer.parseInt(commandArgs[5]);
                            int passing = Integer.parseInt(commandArgs[6]);
                            int shooting = Integer.parseInt(commandArgs[7]);

                            try {
                                Player player = new Player(playerName, new Stats(endurance, sprint, dribble, passing, shooting));
                                teams.get(teamName).addPlayer(player);
                            } catch (IllegalArgumentException iae) {
                                System.out.println(iae.getMessage());
                            }
                        }
                        catch (ArrayIndexOutOfBoundsException aiobe) {
                            System.out.println("A name should not be empty.");
                        }
                    break;
                case "Remove":
                     teamName = commandArgs[1];

                         playerName = commandArgs[2];
                         Team currentTeam = teams.get(teamName);
                         try {
                             currentTeam.containPlayer(playerName);
                             currentTeam.removePlayer(playerName);
                         } catch (IllegalArgumentException iae) {
                             System.out.println(iae.getMessage());
                         }
                    break;
                case "Rating":
                        teamName = commandArgs[1];
                        if(!teams.containsKey(teamName)) {
                            System.out.println("Team " + teamName + " does not exist.");
                            continue;
                        }
                        currentTeam = teams.get(teamName);
                        System.out.println(currentTeam.getName() + " - " + Math.round(currentTeam.getRating()));
                    break;
            }
        }
    }
}

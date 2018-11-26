package avatar;

import avatar.benders.*;
import avatar.monuments.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<BaseBenders>> bendersMap = new HashMap<>();
        Map<String, List<BaseMonuments>> monumentMap = new HashMap<>();
        List<String> warCommands = new ArrayList<>();
        int counter = 1;
        String input;

        while (!(input = reader.readLine()).equals("Quit")) {

            String[] inputArgs = input.split(" ");
            String mainCommand = inputArgs[0];
            switch (mainCommand) {

                case "Bender":
                    String type = inputArgs[1];
                    switch (type) {
                        case "Air":
                            bendersMap.putIfAbsent("Air", new ArrayList<>());
                            bendersMap.get("Air")
                                    .add(new AirBender(inputArgs[2], Integer.parseInt(inputArgs[3]), Double.parseDouble(inputArgs[4])));
                            break;
                        case "Water":
                            bendersMap.putIfAbsent("Water", new ArrayList<>());
                            bendersMap.get("Water")
                                    .add(new WaterBender(inputArgs[2], Integer.parseInt(inputArgs[3]), Double.parseDouble(inputArgs[4])));
                            break;
                        case "Fire":
                            bendersMap.putIfAbsent("Fire", new ArrayList<>());
                            bendersMap.get("Fire")
                                    .add(new FireBender(inputArgs[2], Integer.parseInt(inputArgs[3]), Double.parseDouble(inputArgs[4])));
                            break;
                        case "Earth":
                            bendersMap.putIfAbsent("Earth", new ArrayList<>());
                            bendersMap.get("Earth")
                                    .add(new EarthBender(inputArgs[2], Integer.parseInt(inputArgs[3]), Double.parseDouble(inputArgs[4])));
                    }
                    break;

                case "Monument":
                    type = inputArgs[1];
                    switch (type) {
                        case "Air":
                            monumentMap.putIfAbsent("Air", new ArrayList<>());
                            monumentMap.get("Air").add(new AirMonument(inputArgs[2], Integer.parseInt(inputArgs[3])));
                            break;
                        case "Water":
                            monumentMap.putIfAbsent("Water", new ArrayList<>());
                            monumentMap.get("Water").add(new WaterMonument(inputArgs[2], Integer.parseInt(inputArgs[3])));
                            break;
                        case "Fire":
                            monumentMap.putIfAbsent("Fire", new ArrayList<>());
                            monumentMap.get("Fire").add(new FireMonument(inputArgs[2], Integer.parseInt(inputArgs[3])));
                            break;
                        case "Earth":
                            monumentMap.putIfAbsent("Earth", new ArrayList<>());
                            monumentMap.get("Earth").add(new EarthMonument(inputArgs[2], Integer.parseInt(inputArgs[3])));
                            break;
                    }
                    break;
                case "Status":
                    type = inputArgs[1];
                    System.out.println(type + " Nation");
                    if (!bendersMap.containsKey(type)) {
                        System.out.println("Benders: None");
                    } else {
                        System.out.println("Benders:");
                        bendersMap.get(type).forEach(x -> System.out.println("###" + x.toString()));
                    }
                    if (!monumentMap.containsKey(type)) {
                        System.out.println("Monuments: None");
                    } else {
                        System.out.println("Monuments:");
                        monumentMap.get(type).forEach(x -> System.out.println("###" + x.toString()));
                    }
                    break;
                case "War":
                    type = inputArgs[1];

                    warCommands.add("War " + counter + " issued by " + type);
                    counter++;

                final Map<String, List<BaseBenders>> finalBendersMap = bendersMap;
                final Map<String, List<BaseMonuments>> finalMonumentsMap = monumentMap;

                String highestType = bendersMap.entrySet().stream()
                        .sorted(Comparator.comparing((Map.Entry<String, List<BaseBenders>> y) -> {
                                if (finalMonumentsMap.containsKey(y.getKey())) {
                                    double currentBenderPower = finalBendersMap.get(y.getKey()).stream()
                                            .mapToDouble(BaseBenders::currentPower).sum();
                                    double currentMonumentBonus = finalMonumentsMap.get(y.getKey()).stream()
                                            .mapToDouble(BaseMonuments::getAffinity).sum();
                                    return ((currentBenderPower * currentMonumentBonus) / 100.0) + currentBenderPower;
                                } else {
                                    return finalBendersMap.get(y.getKey()).stream()
                                            .mapToDouble(BaseBenders::currentPower).sum();
                                }
                        }, Comparator.reverseOrder())).findFirst().get().getKey();

                    List<BaseBenders> highestTypeBendersList = bendersMap.get(highestType);

                    if (monumentMap.containsKey(highestType)) {
                        List<BaseMonuments> highestTypeMonumentsList = monumentMap.get(highestType);
                        monumentMap = new HashMap<>();
                        monumentMap.put(highestType, highestTypeMonumentsList);
                    } else {
                        monumentMap = new HashMap<>();
                    }
                    bendersMap = new HashMap<>();
                    if(highestType != null) {
                        bendersMap.put(highestType, highestTypeBendersList);
                    }
                    break;
            }
        }

        warCommands.forEach(System.out::println);
    }

}

package militaryElite;

import militaryElite.classImpl.*;
import militaryElite.interfaces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Map<Integer, PrivateImpl> privates = new HashMap<>();
        HashSet<Soldier> soldiers = new LinkedHashSet<>();

        while (!(input = reader.readLine()).equals("End")) {
            String[] inputArgs = input.split(" ");
            String rank = inputArgs[0];
            int id = Integer.parseInt(inputArgs[1]);
            String firstName = inputArgs[2];
            String lastName = inputArgs[3];
            switch (rank) {
                case "Private":
                    double salary = Double.parseDouble(inputArgs[4]);
                    PrivateImpl aPrivateImpl = new PrivateImpl(id, firstName, lastName, salary);
                    soldiers.add(aPrivateImpl);
                    privates.putIfAbsent(aPrivateImpl.getId(), aPrivateImpl);
                    break;
                case "Spy":
                    String codeNumber = inputArgs[4];
                    BaseSoldier spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    soldiers.add(spy);
                    break;
                case "LeutenantGeneral":
                    salary = Double.parseDouble(inputArgs[4]);
                    LeutenantGeneral leutenantGeneral = new LeutenantGeneraImpl(id, firstName, lastName, salary);
                    for (int i = 5; i < inputArgs.length; i++) {
                        final int currentNumber = Integer.parseInt(inputArgs[i]);
                        if (privates.containsKey(currentNumber)) {
                            leutenantGeneral.getPrivateImpls().add(privates.get(currentNumber));
                        }
                    }
                    soldiers.add(leutenantGeneral);
                    break;
                case "Engineer":
                    salary = Double.parseDouble(inputArgs[4]);
                    String corps = inputArgs[5];
                    try {
                        Engineer engineer = new EngineerImpl(id, firstName, lastName, salary, corps);

                        for (int i = 6; i < inputArgs.length - 1; i += 2) {
                            String name = inputArgs[i];
                            int hours = Integer.parseInt(inputArgs[i + 1]);
                            engineer.getRepairImpls().add(new RepairImpl(name, hours));
                        }
                        soldiers.add(engineer);
                    } catch (IllegalArgumentException iae) {
                        break;
                    }
                    break;
                case "Commando":
                    salary = Double.parseDouble(inputArgs[4]);
                    corps = inputArgs[5];
                    try {
                        Commando commando = new CommandoImpl(id, firstName, lastName, salary, corps);
                        for (int i = 6; i < inputArgs.length - 1; i += 2) {
                            String codeName = inputArgs[i];
                            String currentState = inputArgs[i + 1];
                            Mission mission = new MissionImpl(codeName, currentState);
                            if (mission.completeMission(currentState)) {
                                commando.getMissions().add(mission);
                            }
                        }
                        soldiers.add(commando);
                    } catch (IllegalArgumentException iae) {
                        break;
                    }

                    break;
            }
        }

        soldiers.forEach(System.out::println);

    }
}

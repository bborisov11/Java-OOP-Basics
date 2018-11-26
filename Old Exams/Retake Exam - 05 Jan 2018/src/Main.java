import Colonists.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        String[] capacityArgs = reader.readLine().split(" ");
        int maxFamilyCount = Integer.parseInt(capacityArgs[0]);
        int maxFamilyCapacity = Integer.parseInt(capacityArgs[1]);

        Colony colony = new Colony(maxFamilyCount, maxFamilyCapacity);

        while(!(input = reader.readLine()).equals("end")) {
            String[] inputArgs = input.split(" ");
            String command = inputArgs[0];
            switch (command) {
                case "insert":
                    Colonist currentColonist = getCurrentColonist(inputArgs);
                    try {
                        colony.addColonist(currentColonist);
                    }
                    catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "remove":
                    String modificator = inputArgs[1];
                    if(modificator.equals("family")) {
                        colony.removeFamily(inputArgs[2]);
                    }
                    else if(modificator.equals("colonist")) {
                        colony.removeColonist(inputArgs[2], inputArgs[3]);
                    }
                    break;
                case "grow":
                    colony.grow(Integer.parseInt(inputArgs[1]));
                    break;
                case "potential":
                    System.out.println("potential: " + colony.getPotential());
                    break;
                case "capacity":
                    System.out.println(colony.getCapacity());
                    break;
                case "family":
                    try {
                        List<Colonist> colonists = colony.getColonistsByFamilyId(inputArgs[1]);
                        for (Colonist colonist : colonists) {
                            System.out.println("-" + colonist.getId() + ": " + colonist.getPotential());
                        }
                    }
                    catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }

            }
        }
    }

    private static Colonist getCurrentColonist(String[] inputArgs) {
        String classType = inputArgs[1];
        String id = inputArgs[2];
        String familyId = inputArgs[3];
        int talent = Integer.parseInt(inputArgs[4]);
        int age = Integer.parseInt(inputArgs[5]);
        switch (classType) {
            case "SoftwareEngineer":
                return new SoftwareEngineer(id,familyId,talent,age);
            case "HardwareEngineer":
                return new HardwareEngineer(id,familyId,talent,age);
            case "Soldier":
                return new Soldier(id,familyId,talent,age);
            case "GeneralPractitioner":
                String sign = inputArgs[6];
                return new GeneralPractitioner(id,familyId,talent,age,sign);
            case "Surgeon":
                sign = inputArgs[6];
                return new Surgeon(id,familyId,talent,age,sign);
        }
        throw new IllegalArgumentException("WRONG CLASS NAME");
    }


}

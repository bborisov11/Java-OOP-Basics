package birthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("Duplicates")
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<BirthDate> controlList = new ArrayList<>();
        String input;

        while(!(input = reader.readLine()).equals("End")) {
            String[] inputArgs = input.split(" ");
            switch (inputArgs[0]) {
                case "Citizen":
                    BirthDate citizen = new Citizen(inputArgs[1], Integer.parseInt(inputArgs[2]), inputArgs[3],  inputArgs[4]);
                    controlList.add(citizen);
                    break;
                case "Robot":
                BorderControl robot = new Robot(inputArgs[1], inputArgs[2]);
                break;
                case "Pet":
                    BirthDate pet = new Pet(inputArgs[1], inputArgs[2]);
                    controlList.add(pet);
                    break;
            }
        }

        String givenYear = reader.readLine();

        for (BirthDate petsAndCitizens : controlList) {
            if(petsAndCitizens.getBirthDate(givenYear)) {
                System.out.println(petsAndCitizens);
            }
        }
    }
}

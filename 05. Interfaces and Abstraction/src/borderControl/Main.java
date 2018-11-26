package borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<BorderControl> controlList = new ArrayList<BorderControl>();
        String input;

        while(!(input = reader.readLine()).equals("End")) {
            String[] inputArgs = input.split(" ");
            if(inputArgs.length == 3) {
                BorderControl citizen = new Citizen(inputArgs[0],Integer.parseInt(inputArgs[1]),inputArgs[2]);
                controlList.add(citizen);
            }
            else if(inputArgs.length == 2) {
                BorderControl robot = new Robot(inputArgs[0],inputArgs[1]);
                controlList.add(robot);
            }
        }
        String fakeIds = reader.readLine();

        for (BorderControl borderControl : controlList) {
            if(borderControl.fakeIds(fakeIds)) {
                System.out.println(borderControl);
            }
        }
    }
}

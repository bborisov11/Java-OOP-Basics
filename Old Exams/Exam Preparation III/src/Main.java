import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HealthManager healthManager = new HealthManager();
        String input;

        while(!(input = reader.readLine()).equals("BEER IS COMING")) {
            String[] inputArgs = input.split(" ");
            String command = inputArgs[0];
            switch (command) {
                case "createOrganism":
                    System.out.println(healthManager.createOrganism(inputArgs[1]));
                    break;
                case "addCluster":
                    System.out.print(healthManager.addCluster(inputArgs[1],
                            inputArgs[2], Integer.parseInt(inputArgs[3]), Integer.parseInt(inputArgs[4])));
                    break;
                case "addCell":
                    System.out.print(healthManager.addCell(inputArgs[1], inputArgs[2], inputArgs[3], inputArgs[4]
                            , Integer.parseInt(inputArgs[5]), Integer.parseInt(inputArgs[6]), Integer.parseInt(inputArgs[7])
                            , Integer.parseInt(inputArgs[8])));
                    break;
                case "checkCondition":
                    System.out.print(healthManager.checkCondition(inputArgs[1]));
                    break;
                case "activateCluster":
                    System.out.println(healthManager.activateCluster(inputArgs[1]));
                    break;
            }
        }
    }
}

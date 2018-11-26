package mordorsCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine().toLowerCase();

            Gandalf gandalf = new Gandalf(input.trim().split("\\s+"));
            System.out.println(gandalf.calculatingPoints());

            System.out.println(gandalf.mood());
   }
}

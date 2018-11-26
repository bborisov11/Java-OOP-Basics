package foodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

//@SuppressWarnings("Duplicates")
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Buyer> buyers = new TreeMap<>();
        int numberOfPeople = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = reader.readLine().split(" ");

            if(input.length == 4) {
                Buyer citizen = new Citizen(input[0],Integer.parseInt(input[1]),input[2],input[3]);
                buyers.putIfAbsent(input[0], citizen);
            }
            else if(input.length == 3) {
                Buyer rebel = new Rebel(input[0],Integer.parseInt(input[1]), input[2]);
                buyers.putIfAbsent(input[0],rebel);
            }
        }

        String input;
        while(!(input = reader.readLine()).equals("End")) {
            if(buyers.containsKey(input)) {
                buyers.get(input).buyFood();
            }
        }

        System.out.println(buyers.values().stream().mapToInt(Buyer::Food).sum());

    }
}

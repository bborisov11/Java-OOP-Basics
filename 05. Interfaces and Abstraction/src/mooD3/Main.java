package mooD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("[ |]+");

        if(input[1].equals("Demon")) {
            Functionality demon = new Demon(input[0], Integer.parseInt(input[3]),Double.parseDouble(input[2]));
            demon.hashedPassword(input[0]);
            System.out.println(demon);
        }
        else if(input[1].equals("Archangel")) {
            Functionality archangel = new Archangel(input[0], Integer.parseInt(input[3]),Double.parseDouble(input[2]));
            archangel.hashedPassword(input[0]);
            System.out.println(archangel);
        }
    }
}

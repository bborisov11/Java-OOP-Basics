package telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Smartphone smartphone = new Smartphone();
        String[] phoneNumbers  = reader.readLine().split("\\s+");
        String[] addresses = reader.readLine().split("\\s+");

        for (int i = 0; i < phoneNumbers.length; i++) {
            smartphone.callPhone(phoneNumbers[i]);
        }
        for (int i = 0; i < addresses.length; i++) {
            smartphone.browse(addresses[i]);
        }
    }
}

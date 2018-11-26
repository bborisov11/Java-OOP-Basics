package onlineRadioDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfSongs = Integer.parseInt(reader.readLine());
        int totalMinutes = 0;
        int totalSeconds = 0;
        int songCounter = 0;
        for (int i = 0; i < countOfSongs; i++) {
            String[] strArgs = reader.readLine().split("[;:]+");
            String artistName = strArgs[0];
            String songName = strArgs[1];
            int minutes = Integer.parseInt(strArgs[2]);
            int seconds = Integer.parseInt(strArgs[3]);

            int currentTotalTime = (minutes * 60) + seconds;
            int minLength = 0;
            int maxLength = (14 * 60) + 59;

            if(currentTotalTime < minLength || currentTotalTime > maxLength) {
                System.out.println("Invalid song length.");
            }

            try {
                RadioDatabase radioDatabase = new RadioDatabase(artistName,songName,minutes,seconds);
                totalMinutes += minutes;
                totalSeconds +=seconds;
                System.out.println("Song added.");
                songCounter++;
            }
            catch (InvalidSongLengthException | InvalidArtistNameException isle) {
                System.out.println(isle.getMessage());
            }
        }

        int SECONDS = totalSeconds % 60;
        int minutes = totalSeconds/60 + totalMinutes;
        int HOURS = minutes / 60;
        int MINUTES = minutes % 60;

        System.out.println("Songs added: " + songCounter);
        System.out.println("Playlist length: " + HOURS + "h " + MINUTES + "m " + SECONDS +"s");
    }
}

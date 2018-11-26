package onlineRadioDatabase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RadioDatabase {
    private static final String ARTIST_NAME_SHOULD_BE_BETWEEN_3_AND_20_SYMBOLS = "Artist name should be between 3 and 20 symbols.";
    private static final String SONG_NAME_SHOULD_BE_BETWEEN_3_AND_30_SYMBOLS = "Song name should be between 3 and 30 symbols.";
    private static final String SONG_MINUTES_SHOULD_BE_BETWEEN_0_AND_14 = "Song minutes should be between 0 and 14.";
    private static final String SONG_SECONDS_SHOULD_BE_BETWEEN_0_AND_59 = "Song seconds should be between 0 and 59.";
    public static final String INVALID_SONG_LENGTH = "Invalid song length.";
    private String artistName;
    private String songName;
    private int minutes;
    private int seconds;


    public RadioDatabase(String artistName, String songName, int minutes, int seconds) throws ParseException {
        this.setArtistName(artistName);
        this.setSongName(songName);
    //    this.checkSongLength(minutes,seconds);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    public String getArtistName() {
        return artistName;
    }

    private void setArtistName(String artistName) {
        if(artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException(ARTIST_NAME_SHOULD_BE_BETWEEN_3_AND_20_SYMBOLS);
        }
        this.artistName = artistName;
    }

    public String getSongName() {
        return songName;
    }

    private void setSongName(String songName) {
        if(songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException(SONG_NAME_SHOULD_BE_BETWEEN_3_AND_30_SYMBOLS);
        }
        this.songName = songName;
    }

    public int getMinutes() {
        return minutes;
    }

    private void setMinutes(int minutes) {
        if(minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException(SONG_MINUTES_SHOULD_BE_BETWEEN_0_AND_14);
        }
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    private void setSeconds(int seconds) {
        if(seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException(SONG_SECONDS_SHOULD_BE_BETWEEN_0_AND_59);
        }
        this.seconds = seconds;
    }

  //  private void checkSongLength(int minutes, int seconds) throws ParseException {
  //      String time = minutes + ":" + seconds;
  //      try {
  //          DateFormat df = new SimpleDateFormat("mm:ss");
  //          Date currentDate = df.parse(time);
  //          Date firstDate = df.parse("00:00");
  //          Date secondDate = df.parse("14:59");
//
  //          if(currentDate.before(firstDate) || currentDate.after(secondDate)) {
  //              throw new InvalidSongLengthException(INVALID_SONG_LENGTH);
  //          }
  //      }
  //      catch (Exception ex) {
  //          throw new InvalidSongLengthException(INVALID_SONG_LENGTH);
  //      }
//
  //  }
}

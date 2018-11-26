package onlineRadioDatabase;

public class InvalidSongException extends IllegalArgumentException {
    public InvalidSongException() {
    }

    public InvalidSongException(String s) {
        super(s);
    }
}

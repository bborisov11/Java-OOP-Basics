import java.util.regex.Matcher;

public class Test {
    public static void main(String[] args) {
        double avg1 = Math.ceil(75+85+84+92+67)/5;
        double avg2 = Math.ceil(95+82+82+89+68)/5;
        double avg = Math.ceil(avg1 + avg2)/2;
        System.out.println(avg1);
        System.out.println(avg2);
        System.out.println(avg);
    }
}

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class program {
    public static void main(String[] args) {
        System.out.println("Привет мир!");
        LocalDateTime now = LocalDateTime.now ();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.YYYY");
        System.out.println(formatter.format(now));
    }        
}
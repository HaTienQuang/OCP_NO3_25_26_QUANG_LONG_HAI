import java.time.LocalDateTime;

public class TestTime {
    public static void run() {
        System.out.println("Now: " + Time.now());
        LocalDateTime t1 = LocalDateTime.now();
        LocalDateTime t2 = t1.plusSeconds(120);
        System.out.println("Diff: " + Time.diffInSeconds(t1, t2) + " seconds");
    }
}

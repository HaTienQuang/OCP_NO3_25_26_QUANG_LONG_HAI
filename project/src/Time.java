import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
    public static String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static long diffInSeconds(LocalDateTime t1, LocalDateTime t2) {
        return java.time.Duration.between(t1, t2).getSeconds();
    }
}

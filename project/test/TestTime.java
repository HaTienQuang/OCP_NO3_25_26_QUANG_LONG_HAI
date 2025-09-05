import src.Time;
public class TestTime {
    public static void main(String[] args) {
        Time t1 = new Time();
        Time t2 = new Time(23, 59, 59);

        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);

        t1.setHour(7).setMinute(30).setSecond(15);
        System.out.println("Updated t1 = " + t1);
    }
}

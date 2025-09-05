public class TestUser {
    public static void run() {
        User u = new User("Alice", 20);
        System.out.println(u);
        u.setAge(25);
        System.out.println("Updated: " + u);
    }
}

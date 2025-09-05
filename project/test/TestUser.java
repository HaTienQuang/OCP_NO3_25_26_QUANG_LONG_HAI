import src.User;
public class TestUser {
    public static void main(String[] args) {
        User u1 = new User();
        User u2 = new User("hai", "123");
        User u3 = new User("quang", "abc");

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);

        u1.setUsername("long");
        u1.setPassword("newpass");
        System.out.println("Updated u1: " + u1);
    }
}



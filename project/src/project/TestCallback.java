

public class TestCallback {
    public static void test() {
        Callee callee = new Callee();
        Caller caller = new Caller(callee);

        for (int j = 0; j < 10; j++) {
            caller.go();
        }
    }
}


public class App {
    public static void main(String[] args) {
        System.out.println("Test Sequence");
        TestSequence.test();

        System.out.println("\nTest Callback");
        TestCallback.test();

        System.out.println("\nTest Inner Class");
        InnerClassDemo demo = new InnerClassDemo();
        demo.testInner();
    }
}

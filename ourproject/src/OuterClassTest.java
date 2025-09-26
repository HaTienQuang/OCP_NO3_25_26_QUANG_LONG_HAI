public class OuterClassTest {
    int var1 = 10;
    public class InnerClassTest {
        public void InnerClassTestMethod() {
            System.out.println("var1 = " + var1);
        }
    }

    public static void main(String[] args) {
        OuterClassTest oct = new OuterClassTest();
        OuterClassTest.InnerClassTest ict = oct.new InnerClassTest();
        ict.InnerClassTestMethod();
    }
}

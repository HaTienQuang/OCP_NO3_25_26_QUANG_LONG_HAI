
public class InnerClassDemo {
    public class PublicInner {
        public void show() {
            System.out.println("public inner class");
        }
    }

    private class PrivateInner {
        public void show() {
            System.out.println("private inner class");
        }
    }

    public void testInner() {
        PublicInner pub = new PublicInner();
        pub.show();

        PrivateInner pri = new PrivateInner();
        pri.show();
    }
}

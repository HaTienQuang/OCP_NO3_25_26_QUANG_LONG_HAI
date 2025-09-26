public class TestCallback {
    public static void main(String[] args) {
        Callee callee = new Callee();           // Đối tượng thực thi
        Caller caller = new Caller(callee);     // Truyền vào Caller
        caller.go();                            // Gọi callback
        caller.go();                            // Gọi nhiều lần để thấy i tăng
    }
}

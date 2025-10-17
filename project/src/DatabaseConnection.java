import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://pg-1ee2113a-haido49533.c.aivencloud.com:19636/defaultdb?sslmode=require";
        String user = "avnadmin";
        String password = "AVNS_a5V1dYsjqfCv4PxFC2b"; 

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println(" Kết nối thành công tới Aiven PostgreSQL!");
        } catch (SQLException e) {
            System.out.println(" Lỗi kết nối CSDL Aiven: " + e.getMessage());
        }
    }
}

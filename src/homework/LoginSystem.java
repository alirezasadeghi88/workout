package homework;

import java.sql.*;
import java.util.Scanner;

// کلاس کمکی برای اتصال به دیتابیس
class DatabaseConnection {
    private String url = "jdbc:postgresql://localhost:5432/test2";
    private String user = "postgres";
    private String pass = "postgres";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}

// کلاس مدیریت ورود
class LoginService {
    private Connection conn;

    public LoginService(Connection conn) {
        this.conn = conn;
    }

    public boolean login(String username, String password) throws SQLException {
        // استفاده از PreparedStatement برای جلوگیری از SQL Injection
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();
        return rs.next(); // اگر رکوردی وجود داشت یعنی ورود موفق است
    }
}

// کلاس اصلی برنامه
public class LoginSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DatabaseConnection dbConn = new DatabaseConnection();

        try (Connection conn = dbConn.connect()) {
            LoginService loginService = new LoginService(conn);

            System.out.print("Username: ");
            String uname = sc.nextLine();

            System.out.print("Password: ");
            String pwd = sc.nextLine();

            if (loginService.login(uname, pwd)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid credentials.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
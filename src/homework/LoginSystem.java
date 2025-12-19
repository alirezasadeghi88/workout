package homework;

// وارد کردن کلاس‌های لازم برای JDBC و گرفتن ورودی از کاربر
import java.sql.*;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        // Scanner برای گرفتن ورودی از کاربر (نام کاربری و رمز عبور)
        Scanner sc = new Scanner(System.in);

        // رشته اتصال به دیتابیس PostgreSQL
        // ساختار: jdbc:postgresql://host:port/database
        String url = "jdbc:postgresql://localhost:5432/test2";
        // نام کاربری دیتابیس
        String user = "postgres";
        // رمز عبور دیتابیس
        String pass = "postgres";

        // اتصال به دیتابیس با استفاده از DriverManager
        // try-with-resources باعث می‌شود Connection بعد از پایان کار خودکار بسته شود
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {

            // گرفتن نام کاربری از کاربر
            System.out.print("Username: ");
            String uname = sc.nextLine();

            // گرفتن رمز عبور از کاربر
            System.out.print("Password: ");
            String pwd = sc.nextLine();

            // آماده‌سازی دستور SQL با استفاده از PreparedStatement
            // نکته فنی: استفاده از ? برای جلوگیری از SQL Injection
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM users WHERE username=? AND password=?"
            );

            // جایگزینی مقادیر ورودی کاربر در ? ها
            ps.setString(1, uname); // مقدار اول: username
            ps.setString(2, pwd);   // مقدار دوم: password

            // اجرای کوئری و گرفتن نتیجه‌ها
            ResultSet rs = ps.executeQuery();

            // بررسی اینکه آیا رکوردی پیدا شد یا نه
            if (rs.next()) {
                // اگر رکورد وجود داشت یعنی ورود موفق است
                System.out.println("Login successful!");
            } else {
                // اگر رکوردی نبود یعنی نام کاربری یا رمز عبور اشتباه است
                System.out.println("Invalid credentials.");
            }

        } catch (SQLException e) {
            // مدیریت خطاهای SQL (مثل عدم اتصال یا خطای کوئری)
            e.printStackTrace();
        }
    }
}
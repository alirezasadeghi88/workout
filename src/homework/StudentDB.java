// تعریف پکیج برای سازماندهی کلاس‌ها در پروژه
package homework;

// وارد کردن کتابخانه‌های JDBC برای مدیریت اتصال، اجرای دستورات SQL و کار با نتایج
import java.sql.*;

public class StudentDB {
    public static void main(String[] args) {
        // رشته اتصال (Connection String) برای PostgreSQL
        // ساختار: jdbc:postgresql://host:port/database
        String url = "jdbc:postgresql://localhost:5432/test";
        // نام کاربری دیتابیس
        String user = "postgres";
        // رمز عبور دیتابیس
        String password = "postgres";

        // try-with-resources باعث می‌شود Connection بعد از پایان کار خودکار بسته شود
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Statement برای اجرای دستورات SQL ساده (بدون پارامتر)
            Statement statement = connection.createStatement();

            // ایجاد جدول اگر وجود نداشته باشد
            // نکته فنی: در PostgreSQL برای کلید اصلی افزایشی از SERIAL استفاده می‌کنیم
            // SERIAL در واقع یک shortcut برای ایجاد sequence و مقداردهی خودکار است
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS students (" +
                    "id SERIAL PRIMARY KEY, " +   // ستون id به صورت auto-increment
                    "name VARCHAR(50) NOT NULL, " + // ستون name با محدودیت NOT NULL
                    "age INT)");                   // ستون age از نوع عدد صحیح

            // درج داده در جدول
            // نکته فنی: چون id از نوع SERIAL است، نیازی به مقداردهی دستی ندارد
            statement.executeUpdate("INSERT INTO students(name, age) VALUES('Ali', 20)");

            // اجرای کوئری SELECT برای خواندن همه رکوردها
            // نکته فنی: ResultSet یک cursor است که داده‌ها را رکورد به رکورد برمی‌گرداند
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            // پیمایش روی نتایج
            // نکته فنی: resultSet.next() هر بار یک رکورد جدید را می‌خواند
            while (resultSet.next()) {
                // گرفتن مقدار ستون‌ها با نامشان
                // getInt برای ستون عددی، getString برای ستون متنی
                System.out.println(resultSet.getInt("id") + " - " +
                        resultSet.getString("name") + " - " +
                        resultSet.getInt("age"));
            }

        } catch (SQLException e) {
            // مدیریت خطاهای SQL
            // نکته فنی: SQLException شامل اطلاعاتی مثل کد خطا، پیام دیتابیس و stack trace است
            e.printStackTrace();
        }
    }
}
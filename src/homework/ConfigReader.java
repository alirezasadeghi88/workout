// تعریف پکیج برای سازماندهی کلاس‌ها در پروژه
package homework;

// وارد کردن کلاس‌های لازم برای کار با فایل و Properties
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    public static void main(String[] args) {
        // ایجاد یک شیء Properties برای نگهداری کلید-مقدارهای تنظیمات
        Properties properties = new Properties();

        try {
            // باز کردن فایل properties از مسیر مشخص‌شده
            // نکته فنی: FileInputStream جریان باینری فایل را می‌خواند
            FileInputStream fileInputStream = new FileInputStream("E:\\projects\\workout\\src\\homework\\db.properties");

            // بارگذاری محتویات فایل در شیء Properties
            // نکته فنی: فایل باید به صورت key=value باشد
            properties.load(fileInputStream);

            // خواندن مقادیر تنظیمات با کلیدهای مشخص
            String dbUrl = properties.getProperty("db.url");
            String dbUser = properties.getProperty("db.user");
            String dbPassword = properties.getProperty("db.password");

            // چاپ مقادیر برای تست
            System.out.println("DataBase URL :" + dbUrl);
            System.out.println("User :" + dbUser);
            System.out.println("Password :" + dbPassword);

        } catch (Exception e) {
            // مدیریت خطاها: اگر فایل وجود نداشته باشد یا فرمت اشتباه باشد
            throw new RuntimeException(e);
        }
    }
}
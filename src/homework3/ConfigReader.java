package homework3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
    public static void main(String[] args) {
        Properties properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream("E:\\projects\\workout\\src\\homework\\db.properties");
            properties.load(fileInputStream);

            String dbUrl = properties.getProperty("db.url");
            String dbUser = properties.getProperty("db.user");
            String dbPassword = properties.getProperty("db.password");

            System.out.println("Url:" + dbUrl);
            System.out.println("User:" + dbUser);
            System.out.println("Password:" + dbPassword);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package homework2;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    public static void main(String[] args) {

        Properties properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream("E:\\projects\\workout\\src\\homework\\db.properties");
            properties.load(fileInputStream);

            String dbUrl = properties.getProperty("db.url");
            String dbUser = properties.getProperty("db.user");
            String dbpassword = properties.getProperty("db.password");

            System.out.println("URL:" + dbUrl);
            System.out.println("USER:" + dbUser);
            System.out.println("PASSWORD:" + dbpassword);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package homework5;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    public static void main(String[] args) {

        Properties properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream("E:\\projects\\workout\\src\\homework\\db.properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

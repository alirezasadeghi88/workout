package homework5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentDB {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/testdb";
        String user = "postgres";
        String password = "postgres";

        try(Connection connection = DriverManager.getConnection(url,user,password)) {
            Statement statement = connection.createStatement();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

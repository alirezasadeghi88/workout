package homework5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDB {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/testdb";
        String user = "postgres";
        String password = "postgres";

        try(Connection connection = DriverManager.getConnection(url,user,password)) {
            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS students " +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(50) NOT NULL, " +
                    "age INT)");
            statement.executeUpdate("INSERT INTO students(name,age)VALEUS(Ali,20)");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

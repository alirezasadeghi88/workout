package homework5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:postgresql://localhost:5432/testdb";
        String user = "postgres";
        String password = "postgres";

        try(Connection connection = DriverManager.getConnection(url,user,password)) {

            System.out.println("USER NAME :");
            String username = scanner.nextLine();

            System.out.println("PASSWORD :");
            String pwd = scanner.nextLine();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");

            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

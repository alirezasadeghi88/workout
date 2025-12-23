package homework5;

import java.sql.Connection;
import java.sql.DriverManager;
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

package homework5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args)throws IOException {

        Scanner scanner = new Scanner(System.in);

        FileWriter fileWriter = new FileWriter("contacts.txt", true);

        System.out.println("ENTER NAME :");
        String name = scanner.nextLine();

        System.out.println("ENTER PHONE :");
        String phone = scanner.nextLine();

        fileWriter.write(name + " , " + phone);
        fileWriter.close();

        System.out.println("Contacts saved !");
    }
}

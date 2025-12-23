package homework5;

import java.io.BufferedReader;
import java.io.FileReader;
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

        fileWriter.write(name + " , " + phone + System.lineSeparator());
        fileWriter.close();

        System.out.println("Contacts saved !");
        BufferedReader bufferedReader = new BufferedReader(new FileReader("contacts.txt"));
        String line;

        while ((line = bufferedReader.readLine())!=null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }
}

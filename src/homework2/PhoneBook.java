package homework2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args)throws IOException {

        Scanner scanner = new Scanner(System.in);

        FileWriter fileWriter = new FileWriter("contacts.txt",true);

        System.out.print("ENTER NAME :");
        String name = scanner.nextLine();

        System.out.print("ENTER PHONE :");
        String phone = scanner.nextLine();

        fileWriter.write(name + " , " + phone + "\n");
        fileWriter.close();

        System.out.println("Contacts saved!");

        BufferedReader bufferedReader = new BufferedReader(new FileReader("contacts.txt"));
        String line;
        System.out.println("All contacts :");

        while ((line = bufferedReader.readLine())!=null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }
}

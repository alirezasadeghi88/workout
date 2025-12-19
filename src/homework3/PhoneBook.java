package homework3;

import java.io.*;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args)throws IOException {

        Scanner scanner = new Scanner(System.in);

        FileWriter fileWriter = new FileWriter("contacts.txt",true);

        System.out.print("NAME :");
        String name = scanner.nextLine();
        System.out.print("PHONE :");
        String phone = scanner.nextLine();

        fileWriter.write(name + " , " + phone + "\n");
        fileWriter.close();

        System.out.println("Contacts saved!");

        BufferedReader bufferedReader = new BufferedReader(new FileReader("contacts.txt"));
        String line;
        System.out.println("All contacts :");

        while ((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }

        bufferedReader.close();
    }
}

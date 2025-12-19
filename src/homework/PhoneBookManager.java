package homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PhoneBookManager {
    private static final String FILE_PATH = "contacts.txt";

    public void addContact(int id,String name,String phone) {
        try(FileWriter fileWriter =new FileWriter(FILE_PATH)){
            fileWriter.write(id + " , " + name + " , " + phone + "\n");
            System.out.println("Contact saved successfully!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void showAllContacts() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("\nAll contacts:");
            while ((line = bufferedReader.readLine())!= null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String phone = parts[2];
                System.out.println("ID: " + id + " | Name: " + name + " | Phone: " + phone);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void searchById(int searchId) {
        boolean found = false;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = bufferedReader.readLine())!= null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String phone = parts[2];

                if (id == searchId) {
                    System.out.println("Contact found:");
                    System.out.println("ID: " + id + " | Name: " + name + " | Phone: " + phone);

                    found = true;
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (!found){
            System.out.println("No contact found with ID: " + searchId);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PhoneBookManager manager = new PhoneBookManager();

        while (true) {
            System.out.println("\n--- PhoneBook Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Show All Contacts");
            System.out.println("3. Search Contact by ID");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice =  Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    System.out.print("ENTER ID :");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("ENTER NAME :");
                    String name = scanner.nextLine();

                    System.out.print("ENTER PHONE :");
                    String phone = scanner.nextLine();
                    manager.addContact(id,name, phone);
                    break;
            }
        }
    }
}

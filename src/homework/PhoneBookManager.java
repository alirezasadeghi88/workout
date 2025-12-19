package homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

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
            while ((line = bufferedReader.readLine())!= null);
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            String phone = parts[2];
            System.out.println("ID: " + id + " | Name: " + name + " | Phone: " + phone);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

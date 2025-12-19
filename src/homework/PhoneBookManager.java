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

  }
}

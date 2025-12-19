// تعریف پکیج برای سازماندهی کلاس‌ها در پروژه
package homework;

import java.io.BufferedReader;   // برای خواندن فایل به صورت خط‌به‌خط
import java.io.FileReader;       // برای باز کردن فایل جهت خواندن
import java.io.FileWriter;       // برای نوشتن داده در فایل
import java.io.IOException;      // مدیریت خطاهای ورودی/خروجی
import java.util.Scanner;        // گرفتن ورودی از کاربر

public class PhoneBook {
    public static void main(String[] args) throws IOException {
        // ایجاد شیء Scanner برای گرفتن ورودی از کاربر
        Scanner scanner = new Scanner(System.in);

        // FileWriter برای نوشتن در فایل contacts.txt
        // پارامتر true یعنی داده‌ها به انتهای فایل اضافه شوند (append mode)
        FileWriter fileWriter = new FileWriter("contacts.txt", true);

        // گرفتن نام از کاربر
        System.out.print("Enter name :");
        String name = scanner.nextLine();

        // گرفتن شماره تلفن از کاربر
        System.out.print("Enter phone :");
        String phone = scanner.nextLine();

        // نوشتن نام و شماره در فایل به صورت name,phone
        fileWriter.write(name + "," + phone + "\n");
        fileWriter.close(); // بستن فایل بعد از نوشتن

        System.out.println("Contacts saved!");

        // خواندن کل فایل contacts.txt و نمایش همه مخاطبین
        BufferedReader bufferedReader = new BufferedReader(new FileReader("contacts.txt"));
        String line;
        System.out.println("All contacts :");
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line); // چاپ هر خط (هر مخاطب)
        }
        bufferedReader.close(); // بستن فایل بعد از خواندن
    }
}
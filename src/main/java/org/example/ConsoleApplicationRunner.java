package org.example;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Validate.*;

@Component
public class ConsoleApplicationRunner implements CommandLineRunner {
    private final ContactsManager contactsManager;

    static String textMenu = """
            Введите цифру:
            1 Показать список контактов
            2 Добавить контакт
            3 Удалить контакт по email
            0 Завершить программу""";

    public ConsoleApplicationRunner(ContactsManager contactsManager) throws IOException {
        this.contactsManager = contactsManager;
        run();
    }

    @Override
    public void run() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println(textMenu);
        String number = "";
        while (!number.equals("0")) {
            number = scanner.nextLine();
            switch (number) {
                case "1":
                    readAllContacts().forEach(System.out::println);
                    System.out.println(textMenu);
                    break;
                case "2":
                    addContact();
                    System.out.println(textMenu);
                    break;
                case "3":
                    System.out.print("Введите email для удаления контакта: ");
                    String email = scanner.nextLine();
                    removeContact(email);
                    System.out.println(textMenu);
                    break;
                default:
                    System.out.println("unknown number");
                    System.out.println(textMenu);
                    break;
            }
        }
    }

    @Override
    public boolean addContact() {
        Scanner scanner = new Scanner(System.in);
        PersonInfo personInfo = new PersonInfo();

        System.out.print("Введите ФИО: ");
        String fullName = scanner.nextLine();
        boolean flagValidate = validateName(fullName);
        if (!flagValidate) {
            System.out.println("Вы ввели не корректное ФИО");
            return false;
        }
        personInfo.setFullName(fullName);
        System.out.print("Введите телефон: ");
        String phone = scanner.nextLine();
        flagValidate = validatePhone(phone);
        if (!flagValidate) {
            System.out.println("Вы ввели телефон не по формату +7967071071");
            return false;
        }
        personInfo.setPhoneNumber(phone);
        System.out.print("Введите email: ");
        String email = scanner.nextLine();

        flagValidate = validateEmail(email);
        if (!flagValidate) {
            System.out.println("Вы ввели телефон не по формату +7967071071");
            return false;
        }

        personInfo.setEmail(email);
        try {
            writeContactToFile(personInfo.recordPerson());
            System.out.println("Строка успешно записана в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл.");
        }
        return true;
    }

    @Override
    public void removeContact(String email) throws IOException {
        List<String> listOld = readAllContacts();

        List<String> list = listOld.stream().filter(contacts -> {
            var contactsArray = contacts.split(";");
            return !contactsArray[2].equals(email);
        }).toList();

        if (list.size() != listOld.size()) {
            FileWriter writer = new FileWriter(contactsManager.getContactsFilePath());
            list.forEach(x -> {
                        try {
                            writer.write(x);
                            writer.flush();
                            writer.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        } else {
            System.out.println("Номера с таким email не существует");
        }
    }

    @Override
    public void writeContactToFile(String input) throws IOException {
        File file = new File(contactsManager.getContactsFilePath());
        if (file.exists()) {
            FileWriter writer = new FileWriter(contactsManager.getContactsFilePath(), true);
            writer.write("\n" + input);
            writer.flush();
            writer.close();
        } else {
            FileWriter writer = new FileWriter(contactsManager.getContactsFilePath(), true);
            writer.write(input);
            writer.flush();
            writer.close();
        }
    }

    @Override
    public List<String> readAllContacts() {
        File file = new File(contactsManager.getContactsFilePath());
        if (file.exists()) {
            List<String> list = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(contactsManager.getContactsFilePath()))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    list.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return list;
        }
        return List.of("Записная книжка пустая");
    }
}

package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class EmptyEnvPrinter implements EnvPrinter {
    @Value("${app.env}")
    private String env;
    private ContactsManager contactsManager;

    @Override
    public void printEnv() {
        deleteFile(contactsManager.getContactsFilePath());
    }

    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists() && !file.isDirectory()) {
            file.delete();
            System.out.println("Файл удален");
        } else {
            System.err.println("Ошибка при удалении файла");
        }
    }
}
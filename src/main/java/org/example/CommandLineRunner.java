package org.example;

import java.io.IOException;
import java.util.List;

public interface CommandLineRunner {
    boolean addContact();

    void removeContact(String email) throws IOException;

    void writeContactToFile(String input) throws IOException;

    List<String> readAllContacts() throws IOException;

    void run() throws IOException;
}

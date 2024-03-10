package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Validate.*;

@Component
public class ContactsManager {

    private final String contactsFilePath;

    public ContactsManager(@Value("${contacts.file.path}") String contactsFilePath) {
        this.contactsFilePath = contactsFilePath;
    }

    public String getContactsFilePath() {
        return contactsFilePath;
    }

}

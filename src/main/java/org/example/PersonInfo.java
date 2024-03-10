package org.example;

import org.springframework.stereotype.Component;

@Component
public class PersonInfo {
    private String fullName;
    private String phoneNumber;
    private String email;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String recordPerson() {
        return fullName + ";" + phoneNumber + ";" + email + ";";
    }
}

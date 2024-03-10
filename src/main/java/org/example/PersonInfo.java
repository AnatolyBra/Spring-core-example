package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PersonInfo {
    @Value("${app.person.fullName}")
    private String fullName;
    @Value("${app.person.phoneNumber}")
    private String phoneNumber;
    @Value("${app.person.email}")
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

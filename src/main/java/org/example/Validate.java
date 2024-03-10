package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static final String NAME_PATTERN = "\\b[А-Яа-яЁё]{3,10}+\\b||" +
            "\\b[А-Яа-яЁё]{3,13}\\s[А-Яа-яЁё]{3,13}+||" +
            "\\b[А-Яа-яЁё]{3,13}\\s[А-Яа-яЁё]{3,13}+\\s[А-Яа-яЁё]{3,13}+\\b";

    private static final String PHONE_PATTERN = "\\+\\d{11}$";
    private static final String EMAIL_PATTERN = "^[^@\\s]+@([^@\\s]+\\.)+[\\w]{2,}$";

    private static boolean validate(String text, String reg) {
        if (text == null || text.trim().isEmpty()) {
            System.out.println("Вы ввели пустое значение или пробел");
            return false;
        }

        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean validateName(String name) {
        return validate(name, NAME_PATTERN);
    }

    public static boolean validatePhone(String phone) {
        return validate(phone, PHONE_PATTERN);
    }

    public static boolean validateEmail(String email) {
        return validate(email, EMAIL_PATTERN);
    }

}

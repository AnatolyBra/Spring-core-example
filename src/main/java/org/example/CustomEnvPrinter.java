package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomEnvPrinter implements EnvPrinter {
    @Value("${app.env}")
    private String env;

    @Override
    public void printEnv() {
        System.out.println("CustomEnvPrinter is calling...");
        System.out.println("Env is: " + env);
    }
}

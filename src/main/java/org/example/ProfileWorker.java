package org.example;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ProfileWorker {
    private final EnvPrinter envPrinter;

    public ProfileWorker(EnvPrinter envPrinter) {
        this.envPrinter = envPrinter;
    }

    @PostConstruct
    public void doWork(){
        envPrinter.printEnv();
    }
}

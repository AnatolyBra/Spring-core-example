package org.example.config;

import org.example.EnvPrinter;
import org.example.CustomEnvPrinter;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application-custom.properties")
@Profile("custom")
public class CustomAppConfig {
    @Bean
    public EnvPrinter envPrinter() {
        return new CustomEnvPrinter();
    }
}

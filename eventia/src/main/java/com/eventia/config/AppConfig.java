package com.eventia.config;

import com.eventia.service.Printer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.eventia")
public class AppConfig {

    @Bean
    public Printer deskPrinter() {
        return new Printer("desk");
    }

    @Bean
    public Printer backPrinter() {
        return new Printer("back");
    }
}

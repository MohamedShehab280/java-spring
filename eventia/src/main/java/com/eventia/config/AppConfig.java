package com.eventia.config;

import com.eventia.model.Event;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Event workshop() {
        return new Event(1L, "Spring Boot Workshop", 40);
    }
}

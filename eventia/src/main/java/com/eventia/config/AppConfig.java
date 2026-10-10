package com.eventia.config;

import com.eventia.model.Event;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean("mainEvent")
    public Event workshop() {
        return new Event(1L, "Spring Boot Workshop", 40);
    }

    @Bean
    public Event conference() {
        return new Event(2L, "Java Conference", 200);
    }
}

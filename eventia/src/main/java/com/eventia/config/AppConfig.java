package com.eventia.config;

import com.eventia.service.BookingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BookingService bookingService() {
        return new BookingService();
    }
}

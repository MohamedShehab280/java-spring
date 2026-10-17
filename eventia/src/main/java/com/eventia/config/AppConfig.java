package com.eventia.config;

import com.eventia.service.BookingService;
import com.eventia.service.SmtpEmailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SmtpEmailSender smtpEmailSender() {
        return new SmtpEmailSender();
    }

    @Bean
    public BookingService bookingService(SmtpEmailSender smtpEmailSender) {
        return new BookingService(smtpEmailSender);
    }
}

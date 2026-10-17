package com.eventia.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SmtpEmailSender {

    private final BookingService bookingService;

    public SmtpEmailSender(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void send(String to, String subject, String body) {
        log.info("[SMTP] -> {} | {}", to, subject);
    }
}

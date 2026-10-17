package com.eventia.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class BookingService {

    private SmtpEmailSender emailSender;

    @Autowired
    public BookingService(SmtpEmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void book(String user, String eventTitle) {
        log.info("{} booked a seat for {}", user, eventTitle);
        emailSender.send(user, "Booking confirmation", "your booking for " + eventTitle + " is confirmed");
    }
}

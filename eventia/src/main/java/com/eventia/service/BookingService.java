package com.eventia.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookingService {

    private SmtpEmailSender emailSender;

    public BookingService() {
        log.info("BookingService created");
    }

    public BookingService(SmtpEmailSender emailSender) {
        this.emailSender = emailSender;
        log.info("BookingService created with a sender");
    }

    public SmtpEmailSender getEmailSender() {
        return emailSender;
    }

    public void book(String user, String eventTitle) {
        log.info("{} booked a seat for {}", user, eventTitle);
        if (emailSender == null) {
            log.warn("no sender, nothing was emailed");
            return;
        }
        emailSender.send(user, "Booking confirmation", "your booking for " + eventTitle + " is confirmed");
    }
}

package com.eventia.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Section 3: @Service هي @Component بـ لافتة، ومعناها إن ده طبقة خدمة.
 *
 * constructor injection مش field injection، والسبب هيبان في سكشن 12
 * لما نيجي نعمل mock.
 */
@Slf4j
@Service
public class BookingService {

    private final EmailSender emailSender;

    public BookingService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void book(String user, String eventTitle) {
        log.info("{} booked a seat for {}", user, eventTitle);
        emailSender.send(user, "Booking confirmation", "your booking for " + eventTitle + " is confirmed");
    }
}

package org.example;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        int seats = 2;
        int wanted = 5;

        log.trace("entering main");
        log.debug("found {} seats", seats);
        log.info("booking started");

        Booking booking = new Booking("ahmed@example.com", "Spring Boot Workshop", wanted);
        log.info("the booking: {}", booking);

        if (wanted > seats) {
            log.warn("only {} seats left, asked for {}", seats, wanted);
        }

        try {
            sendMail();
        } catch (Exception e) {
            log.error("could not send confirmation");
            log.error("could not send confirmation", e);
        }
    }

    private static void sendMail() {
        throw new IllegalStateException("mail server not configured");
    }
}

package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        int seats = 2;
        int wanted = 5;

        log.trace("entering main");
        log.debug("found {} seats", seats);
        log.info("booking started");

        if (wanted > seats) {
            log.warn("only {} seats left, asked for {}", seats, wanted);
        }

        try {
            sendMail();
        } catch (Exception e) {
            log.error("could not send confirmation");
        }
    }

    private static void sendMail() {
        throw new IllegalStateException("mail server not configured");
    }
}

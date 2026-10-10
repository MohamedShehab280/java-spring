package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        int seats = 2;

        log.trace("entering main");
        log.debug("found {} seats", seats);
        log.info("booking started");
    }
}

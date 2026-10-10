package com.eventia.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookingService {

    public void book(String user, String eventTitle) {
        log.info("{} booked a seat for {}", user, eventTitle);
    }
}

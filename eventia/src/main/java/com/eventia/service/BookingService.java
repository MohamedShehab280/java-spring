package com.eventia.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Section 2: @Component هي كل اللي محتاجه عشان Spring تلاقي الـ class ده
 * وتعمل منه object. في سكشن 3 هتبقى @Service، وهي نفسها بـ لافتة.
 */
@Slf4j
@Component
public class BookingService {

    public void book(String user, String eventTitle) {
        log.info("{} booked a seat for {}", user, eventTitle);
    }
}

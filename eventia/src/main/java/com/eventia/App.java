package com.eventia;

import com.eventia.config.AppConfig;
import com.eventia.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class App {

    public static void main(String[] args) {
        log.info("building the context now");

        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        log.info("context ready, I asked for nothing yet");

        BookingService bookingService = context.getBean(BookingService.class);

        log.info("now I asked");
        bookingService.book("ahmed@example.com", "Spring Boot Workshop");
    }
}

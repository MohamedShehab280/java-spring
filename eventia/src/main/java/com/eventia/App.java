package com.eventia;

import com.eventia.config.AppConfig;
import com.eventia.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class App {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        BookingService bookingService = context.getBean(BookingService.class);
        bookingService.book("ahmed@example.com", "Spring Boot Workshop");

        log.info("beans in the context: {}", context.getBeanDefinitionCount());
        var desk = (com.eventia.service.Printer) context.getBean("deskPrinter");
        var back = (com.eventia.service.Printer) context.getBean("backPrinter");
        log.info("deskPrinter : {}", desk);
        log.info("backPrinter : {}", back);
        log.info("same object? {}", desk == back);
        log.info("by hand     : {}", new com.eventia.service.Printer("desk"));
    }
}

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
        var b = context.getBean(com.eventia.service.InvoiceBuilder.class);
        Thread ahmed = new Thread(() -> {
            b.start("ahmed"); nap(40); b.addSeat(100); nap(40);
            log.info("{}", b.finish());
        });
        Thread mona = new Thread(() -> {
            nap(20); b.start("mona"); b.addSeat(250); nap(60);
            log.info("{}", b.finish());
        });
        ahmed.start(); mona.start();
        try { ahmed.join(); mona.join(); } catch (InterruptedException e) { }
        log.info("ahmed should owe 100, and mona should owe 250");
    }

    static void nap(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { }
    }
}

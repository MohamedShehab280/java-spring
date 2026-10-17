package com.eventia;

import lombok.extern.slf4j.Slf4j;
import com.eventia.config.AppConfig;
import com.eventia.service.BookingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Section 3: الـ context بيلاقي الـ classes لوحده ويوصّلها ببعض.
 *
 * Spring:
 *     نفس الكلام بالظبط تحت، بس بتلاقي الـ classes لوحدها.
 */
@Slf4j
public class App {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        BookingService bookingService = context.getBean(BookingService.class);
        bookingService.book("ahmed@example.com", "Spring Boot Workshop");

        log.info("beans in the context: {}", context.getBeanDefinitionCount());

        // singleton: نفس الـ instance مرتين
        log.info("same instance? {}",
                context.getBean(BookingService.class) == bookingService);
    }
}

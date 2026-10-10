package com.eventia;

import lombok.extern.slf4j.Slf4j;
import com.eventia.config.AppConfig;
import com.eventia.service.BookingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Section 2: أول لمسة مع Spring.
 *
 * محدش بيكتب new BookingService() هنا. الـ context هو اللي بيعملها،
 * وإحنا بنطلبها منه. الـ wiring والـ abstractions في سكشن 3.
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

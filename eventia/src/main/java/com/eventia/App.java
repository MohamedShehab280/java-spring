package com.eventia;

import com.eventia.config.AppConfig;
import com.eventia.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class App {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        Event a = context.getBean("workshop", Event.class);
        Event b = context.getBean("conference", Event.class);

        log.info("by name workshop   -> {}", a.getTitle());
        log.info("by name conference -> {}", b.getTitle());
        log.info("same twice? {}", context.getBean("workshop", Event.class) == a);
    }
}

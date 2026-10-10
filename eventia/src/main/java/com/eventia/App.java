package com.eventia;

import com.eventia.config.AppConfig;
import com.eventia.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class App {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        Event event = context.getBean(Event.class);
        log.info("getBean(Event.class) now works -> {}", event.getTitle());
    }
}

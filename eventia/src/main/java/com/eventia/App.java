package com.eventia;

import com.eventia.config.AppConfig;
import com.eventia.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class App {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        log.info("beans in the context: {}", context.getBeanDefinitionCount());

        try {
            context.getBean(Event.class);
        } catch (Exception e) {
            log.info("getBean(Event.class) -> {}", e.getMessage());
        }
    }
}

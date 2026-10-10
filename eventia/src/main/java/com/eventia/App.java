package com.eventia;

import com.eventia.config.AppConfig;
import com.eventia.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class App {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        for (String name : context.getBeanDefinitionNames()) {
            log.info("   {}", name);
        }

        try {
            context.getBean("workshop", Event.class);
        } catch (Exception e) {
            log.info("getBean(\"workshop\") -> {}", e.getMessage());
        }
    }
}

package com.eventia;

import com.eventia.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class App {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        log.info("beans in the context: {}", context.getBeanDefinitionCount());
        for (String name : context.getBeanDefinitionNames()) {
            log.info("   {}", name);
        }
    }
}

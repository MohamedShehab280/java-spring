package com.eventia.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Lazy
@Component
public class TicketPrinter {

    public TicketPrinter() {
        log.info("TicketPrinter created");
    }
}

package com.eventia.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Slf4j
@Primary
@Component
public class BackupEmailSender implements EmailSender {

    @Override
    public void send(String to, String subject, String body) {
        log.info("[BACKUP] -> {} | {}", to, subject);
    }
}

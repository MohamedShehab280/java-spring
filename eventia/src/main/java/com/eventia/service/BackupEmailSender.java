package com.eventia.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BackupEmailSender extends SmtpEmailSender {

    public void send(String to, String subject, String body) {
        log.info("[BACKUP] -> {} | {}", to, subject);
    }
}

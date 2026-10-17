package com.eventia.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmtpEmailSender {

    public SmtpEmailSender() {
        log.info("SmtpEmailSender created");
    }

    public void send(String to, String subject, String body) {
        log.info("[SMTP] -> {} | {}", to, subject);
    }
}

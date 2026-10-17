package com.eventia.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Slf4j
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Service
public class InvoiceBuilder {

    private int total = 0;
    private String customer;

    public InvoiceBuilder() {
        log.info("InvoiceBuilder created");
    }

    public void start(String customer) {
        this.customer = customer;
        this.total = 0;
    }

    public void addSeat(int price) {
        this.total += price;
    }

    public String finish() {
        return customer + " owes " + total;
    }
}

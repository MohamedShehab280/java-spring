package com.eventia.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BillingService {

    // No fields. Nothing here changes, so there is nothing to share.
    public String bill(String customer, int seatPrice, int seats) {
        Invoice invoice = new Invoice(customer);
        for (int i = 0; i < seats; i++) {
            nap(20);
            invoice.addSeat(seatPrice);
        }
        return invoice.finish();
    }

    private static void nap(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { }
    }
}

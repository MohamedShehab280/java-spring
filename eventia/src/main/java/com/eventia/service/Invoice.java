package com.eventia.service;

// Not a bean. It needs nothing from the container, so the container
// has no reason to know about it.
public class Invoice {

    private final String customer;
    private int total = 0;

    public Invoice(String customer) {
        this.customer = customer;
    }

    public void addSeat(int price) {
        this.total += price;
    }

    public String finish() {
        return customer + " owes " + total;
    }
}

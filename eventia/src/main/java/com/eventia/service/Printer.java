package com.eventia.service;

public class Printer {

    private final String label;

    public Printer(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label + "@" + System.identityHashCode(this);
    }
}

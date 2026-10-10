package com.eventia.model;

import lombok.Data;

@Data
public class Event {

    private Long id;

    private String title;

    private int capacity;

    public Event() {
    }

    public Event(Long id, String title, int capacity) {
        this.id = id;
        this.title = title;
        this.capacity = capacity;
    }
}

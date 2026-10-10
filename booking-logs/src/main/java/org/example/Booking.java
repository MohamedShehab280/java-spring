package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Booking {

    private String user;
    private String eventTitle;
    private int seats;

    public Booking(String user, String eventTitle, int seats) {
        this.user = user;
        this.eventTitle = eventTitle;
        this.seats = seats;
    }
}

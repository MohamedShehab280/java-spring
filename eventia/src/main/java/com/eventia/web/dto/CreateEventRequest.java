package com.eventia.web.dto;

import java.time.LocalDateTime;

public record CreateEventRequest(
        String title,
        int capacity,
        LocalDateTime startsAt
) {
}

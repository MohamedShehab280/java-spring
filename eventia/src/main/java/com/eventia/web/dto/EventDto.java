package com.eventia.web.dto;

import java.time.LocalDateTime;

public record EventDto(
        Long id,
        String title,
        int capacity,
        LocalDateTime startsAt
) {
}

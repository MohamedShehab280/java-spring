package com.eventia.repository;

import com.eventia.web.dto.EventDto;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryEventRepository {

    private final List<EventDto> events = new ArrayList<>();
    private long nextId = 1;

    public InMemoryEventRepository() {
        save("Spring Boot Workshop", 40, LocalDateTime.now().plusDays(7));
        save("Docker for Beginners", 25, LocalDateTime.now().plusDays(14));
    }

    public List<EventDto> findAll() {
        return events;
    }

    public Optional<EventDto> findById(Long id) {
        for (EventDto event : events) {
            if (event.id().equals(id)) {
                return Optional.of(event);
            }
        }
        return Optional.empty();
    }

    public EventDto save(String title, int capacity, LocalDateTime startsAt) {
        EventDto created = new EventDto(nextId++, title, capacity, startsAt);
        events.add(created);
        return created;
    }

    public boolean deleteById(Long id) {
        for (EventDto event : events) {
            if (event.id().equals(id)) {
                events.remove(event);
                return true;
            }
        }
        return false;
    }
}

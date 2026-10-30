package com.eventia.service;

import com.eventia.repository.InMemoryEventRepository;
import com.eventia.web.dto.CreateEventRequest;
import com.eventia.web.dto.EventDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final InMemoryEventRepository repository;

    public EventService(InMemoryEventRepository repository) {
        this.repository = repository;
    }

    public List<EventDto> findAll() {
        return repository.findAll();
    }

    public Optional<EventDto> findById(Long id) {
        return repository.findById(id);
    }

    public EventDto create(CreateEventRequest request) {
        return repository.save(request.title(), request.capacity(), request.startsAt());
    }
}

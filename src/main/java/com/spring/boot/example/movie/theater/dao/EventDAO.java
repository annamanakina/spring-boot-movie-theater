package com.spring.boot.example.movie.theater.dao;

import com.spring.boot.example.movie.theater.item.Event;

import java.util.Collection;

public class EventDAO extends AbstractDAO<Integer, Event>{

    private Collection<Event> events;

    public EventDAO(Collection<Event> events) {
        this.events = events;
    }

    @Override
    public Collection<Event> getAll() {
        return events;
    }

    @Override
    public Event getById(Integer id) {
        return events.stream().filter(event -> event.getId() == id)
                .findFirst().orElseThrow(() ->new IllegalArgumentException("No such event by id "+ id));
    }

    @Override
    public boolean delete(Integer id) {
        return events.removeIf(event -> event.getId() == id);
    }

    @Override
    public boolean delete(Event event) {
        return events.removeIf(e -> e.equals(event));
    }

    @Override
    public boolean create(Event event) {
        return events.add(event);
    }

    @Override
    public Event update(Event event) {
        return null;
    }

}

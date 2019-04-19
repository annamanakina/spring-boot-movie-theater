package com.spring.boot.example.movie.theater.service;

import com.spring.boot.example.movie.theater.dao.EventDAO;
import com.spring.boot.example.movie.theater.item.Event;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

public class EventService {
   // Manages events (movie shows).
   // Event contains only basic information, like name, base price for tickets, rating (high, mid, low).
   // Event can be presented on several dates and several times within each day.
    // For each dateTime an Event will be presented only in single Auditorium.
   // save,
    // remove,
    // getById,
    // getByName,
    // getAll

   // getForDateRange(from, to) - returns events for specified date range (OPTIONAL)
   // getNextEvents(to) - returns events from now till the ‘to’ date (OPTIONAL)


    private EventDAO eventDAO;

    public EventService(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public Collection<Event> getEvents(){
        return eventDAO.getAll();
    }

    public Collection<Event> getEventByTitle(String title){
         return eventDAO.getAll().stream()
                .filter(event -> event.getTitle().equals(title))
                .collect(toList());
    }

    public Event getEventById(int id){
        return eventDAO.getById(id);
    }

    public boolean remove(int id){
        return eventDAO.delete(id);
    }

    public boolean remove(Event event){
        return eventDAO.delete(event);
    }

    public boolean save(Event event){
        return eventDAO.create(event);
    }

   /* public Collection<Event> getEventsForDateRange(LocalDate start, LocalDate end){
    }

    public Event getNextEvents(LocalDate start, LocalDate end){
    }*/

}

package com.spring.boot.example.movie.theater.dao;

import com.spring.boot.example.movie.theater.item.Ticket;
import lombok.Setter;

import java.util.Collection;
import java.util.Set;

@Setter
public class TicketDAO extends AbstractDAO<Integer, Ticket> {
    public TicketDAO() {
    }

    private Set<Ticket> ticketSet;

    public TicketDAO(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }

    @Override
    public Collection<Ticket> getAll() {
        return ticketSet;
    }

    @Override
    public Ticket getById(Integer id) {
        return ticketSet.stream().filter( ticket -> ticket.getId() == id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No such ticket by id "+ id));
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Ticket ticket) {
        return false;
    }

    @Override
    public boolean create(Ticket ticket) {
        return ticketSet.add(ticket);
    }

    @Override
    public Ticket update(Ticket object) {
        return null;
    }
}

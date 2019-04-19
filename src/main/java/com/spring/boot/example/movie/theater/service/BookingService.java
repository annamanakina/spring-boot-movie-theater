package com.spring.boot.example.movie.theater.service;

import com.spring.boot.example.movie.theater.item.Event;
import com.spring.boot.example.movie.theater.item.Ticket;
import com.spring.boot.example.movie.theater.item.User;
import lombok.NonNull;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Yuriy_Tkach
 */

public interface BookingService {
    /**
     * Getting price when buying all supplied seats for particular event
     *
     * @param event
     *            Event to get base ticket price, vip seats and other
     *            information
     * @param dateTime
     *            Date and time of event air
     * @param user
     *            User that buys ticket could be needed to calculate discount.
     *            Can be <code>null</code>
     * @param seats
     *            Set of seat numbers that user wants to buy
     * @return total price
     */

    double getTicketsPrice(@NonNull Event event, @NonNull LocalDateTime dateTime,
                           @NonNull User user, @NonNull Set<Integer> seats);
    /**
     * Books tickets in internal system. If user is not
     * <code>null</code> in a ticket then booked tickets are saved with it
     *
     * @param tickets
     *            Set of tickets
     */

    void bookTickets(@NonNull Set<Ticket> tickets);
    /**
     * Getting all purchased tickets for event on specific air date and time
     *
     * @param event
     *            Event to get tickets for
     * @param dateTime
     *            Date and time of airing of event
     * @return set of all purchased tickets
     */

    @NonNull Set<Ticket> getPurchasedTicketsForEvent(@NonNull Event event, @NonNull LocalDateTime dateTime);
}

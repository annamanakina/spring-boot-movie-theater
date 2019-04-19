package com.spring.boot.example.movie.theater.service;

import com.spring.boot.example.movie.theater.common.Rating;
import com.spring.boot.example.movie.theater.common.UserRole;
import com.spring.boot.example.movie.theater.dao.TicketDAO;
import com.spring.boot.example.movie.theater.item.Event;
import com.spring.boot.example.movie.theater.item.Ticket;
import com.spring.boot.example.movie.theater.item.User;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
public class BookingServiceImpl implements BookingService {
    private static final int DOUBLE_RATE = 2;
    private static final double PERCENT_20 = 1.2;

    //todo bean ticketDAO
    private TicketDAO ticketDAO;

    private DiscountServiceImpl discountService;

    public BookingServiceImpl() {
    }

    public BookingServiceImpl(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    @Override
    public double getTicketsPrice(@NonNull Event event, @NonNull LocalDateTime dateTime, @NonNull User user, @NonNull Set<Integer> seats) {
        boolean isNegative = seats.stream().anyMatch(integer -> integer < 1);
        if (isNegative) {
            throw new IllegalArgumentException("Number of seat can't be less then 1");
        }

        int disc = discountService.getDiscount(user, event, dateTime, seats.size());
        System.out.println("discount: " + disc);
        //берем общее кол-во билетов, купленное юзером
        //берем каждый десятый и на него считаем скидку
        System.out.println("Tickets: " + user.getTickets().size());
        //todo как проверить. что место vip?
        int previousTickets = user.getTickets().size();

        double basePrice = event.getBasePrice();
        double totalPrice;

        long countVipSeats = event.getAuditoriums().get(dateTime).countVipSeats(seats);
        System.out.println("countVipSeats: "+countVipSeats);

        long countSeats = seats.size() - countVipSeats;
        double totalBasePrice = calculateBaseTotalPrice(countVipSeats, countSeats);

        if (event.getRating() == Rating.HIGH) {
            totalPrice = PERCENT_20 * basePrice * totalBasePrice;
        }else {
            totalPrice = basePrice * totalBasePrice;
        }

        return totalPrice;
    }

    //todo
    /*private boolean isVipSeat(Event event, LocalDateTime dateTime, Integer numberOfSeat){
       return event.getAuditoriums().get(dateTime).getVipSeats().stream().filter( (seat) -> {
            seat.compareTo(numberOfSeat);
        }).findFirst();
    }*/

    private double calculateBaseTotalPrice(double vipSeats, double seats) {
        return vipSeats*DOUBLE_RATE + seats;
    }

    /**
     * Books tickets in internal system. If user is not
     * <code>null</code> in a ticket then booked tickets are saved with it
     *
     * @param tickets
     *            Set of tickets
     */
    @Override
    public void bookTickets(@NonNull Set<Ticket> tickets) {
        for (Ticket ticket : tickets ) {
            User user = ticket.getUser();
            if ( user != null && user.getRole() == UserRole.REGISTERED_USER)
            ticketDAO.create(ticket);
            //System.out.println("ticketDAO.create(ticket); " + ticket);
        }
    }

    /**
     * Getting all purchased tickets for event on specific air date and time
     *
     * @param event
     *            Event to get tickets for
     * @param dateTime
     *            Date and time of airing of event
     * @return set of all purchased tickets
     */

    @Override
    public @NonNull Set<Ticket> getPurchasedTicketsForEvent(@NonNull Event event, @NonNull LocalDateTime dateTime) {
        Set<Ticket> purchasedTickets = ticketDAO.getAll().stream()
                .filter(ticket -> ticket.getEvent().equals(event))
                .filter(ticket -> ticket.getAirDateTime().toString().equals(dateTime.toString()))
                .collect(Collectors.toSet());

        return purchasedTickets;
    }
}

package com.spring.boot.example.movie.theater.item;


import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
public class Ticket extends Entity implements Comparable<Ticket> {
    private LocalDateTime airDateTime;
    private double price;
    private Event event;
    private int seat;
    private User user;

    public Ticket(int id, LocalDateTime airDateTime, double price, Event event, int seat, User user) {
        super(id);
        this.airDateTime = airDateTime;
        this.price = price;
        this.event = event;
        this.seat = seat;
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ticket{");
        sb.append("airDateTime='").append(airDateTime).append('\'');
        sb.append(", price=").append(price);
        sb.append(", event=").append(event);
        sb.append(", seat=").append(seat);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Ticket other) {
        if (other == null) {
            return 1;
        }
        int result = airDateTime.toString().compareTo(other.getAirDateTime().toString());

        if (result == 0) {
            result = event.getTitle().compareTo(other.getEvent().getTitle());
        }
        if (result == 0) {
            result = Integer.compare(seat, other.getSeat());
        }
        return result;
    }
}

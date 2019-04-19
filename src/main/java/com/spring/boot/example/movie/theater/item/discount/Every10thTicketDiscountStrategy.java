package com.spring.boot.example.movie.theater.item.discount;

import com.spring.boot.example.movie.theater.item.Event;
import com.spring.boot.example.movie.theater.item.User;
import lombok.NonNull;
import java.time.LocalDateTime;

public class Every10thTicketDiscountStrategy  implements DiscountStrategy{

    private static final byte DISCOUNT_EVERY_10TH_TICKET = 50;
    private static final byte EVERY_10TH_TICKET = 10;

    @Override
    public byte calculateDiscount(User user, @NonNull Event event, @NonNull LocalDateTime airDateTime, long numberOfTickets) {
        System.out.println("Every10thTicketDiscountStrategy: " + (numberOfTickets / EVERY_10TH_TICKET));
        if (numberOfTickets / EVERY_10TH_TICKET != 0) {
            return DISCOUNT_EVERY_10TH_TICKET;
        }
        return 0;
    }
}

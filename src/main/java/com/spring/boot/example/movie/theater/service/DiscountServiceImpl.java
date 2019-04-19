package com.spring.boot.example.movie.theater.service;

import com.spring.boot.example.movie.theater.item.Event;
import com.spring.boot.example.movie.theater.item.User;
import com.spring.boot.example.movie.theater.item.discount.Discount;
import lombok.NonNull;
import java.time.LocalDateTime;
import java.util.List;

public class DiscountServiceImpl implements DiscountService {

    private List<Discount> discounts;

    public DiscountServiceImpl(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    /**
     * Getting discount based on some rules for user that buys some number of
     * tickets for the specific date time of the event
     *
     * @param user
     *            User that buys tickets. Can be <code>null</code>
     * @param event
     *            Event that tickets are bought for
     * @param airDateTime
     *            The date and time event will be aired
     * @param numberOfTickets
     *            Number of tickets that user buys
     * @return discount value from 0 to 100
     */
    @Override
    public byte getDiscount(User user, @NonNull Event event, @NonNull LocalDateTime airDateTime, long numberOfTickets) {
        //todo execute each strategy to get max available discount
        System.out.println("DiscountServiceImpl " + numberOfTickets);
        //discounts should not add up
        return discounts.stream()
                .map((Discount discount) -> discount.calculateDiscount(user, event, airDateTime, numberOfTickets))
                .max(Byte::compareTo).orElse((byte) 0);
    }
}

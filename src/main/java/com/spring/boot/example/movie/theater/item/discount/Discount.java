package com.spring.boot.example.movie.theater.item.discount;

import com.spring.boot.example.movie.theater.item.Event;
import com.spring.boot.example.movie.theater.item.User;
import lombok.NonNull;

import java.time.LocalDateTime;

public class Discount {
    DiscountStrategy strategy;

    public Discount(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public byte calculateDiscount(User user, @NonNull Event event, @NonNull LocalDateTime airDateTime, long numberOfTickets){
        return strategy.calculateDiscount(user, event, airDateTime, numberOfTickets);
    }
}

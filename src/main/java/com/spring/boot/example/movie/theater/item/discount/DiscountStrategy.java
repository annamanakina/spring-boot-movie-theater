package com.spring.boot.example.movie.theater.item.discount;

import com.spring.boot.example.movie.theater.item.Event;
import com.spring.boot.example.movie.theater.item.User;
import lombok.NonNull;

import java.time.LocalDateTime;

public interface DiscountStrategy {

    //birthday 5% within 5 days of air date
    //every 10th ticket - 50%

    //returns discount value from 0 to 100
    byte calculateDiscount(User user, @NonNull Event event, @NonNull LocalDateTime airDateTime, long numberOfTickets);

}

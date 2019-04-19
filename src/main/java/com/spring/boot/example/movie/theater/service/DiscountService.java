package com.spring.boot.example.movie.theater.service;

import com.spring.boot.example.movie.theater.item.Event;
import com.spring.boot.example.movie.theater.item.User;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

/**
 * @author Yuriy_Tkach
 */

public interface DiscountService {

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
    byte getDiscount(@Nullable User user, @NonNull Event event, @NonNull LocalDateTime airDateTime, long numberOfTickets);

}

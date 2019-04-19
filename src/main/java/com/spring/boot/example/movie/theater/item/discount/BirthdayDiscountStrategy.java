package com.spring.boot.example.movie.theater.item.discount;

import com.spring.boot.example.movie.theater.item.Event;
import com.spring.boot.example.movie.theater.item.User;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BirthdayDiscountStrategy implements DiscountStrategy {
    private static final byte DISCOUNT_BIRTHDAY = 5;

    @Override
    public byte calculateDiscount(User user, @NonNull Event event, @NonNull LocalDateTime airDateTime, long numberOfTickets) {
        LocalDate userBirthday = user.getBirthday();
        LocalDate lastDayOfDiscount = userBirthday.plusDays(5);
        System.out.println("BirthdayDiscountStrategy userBirthday: "+ userBirthday);

        int birthDay = user.getBirthday().getDayOfMonth();
        int birthMonth = user.getBirthday().getMonthValue();

        LocalDate nowDate = LocalDate.now();
        int nowDay = nowDate.getDayOfMonth();
        int nowMonth = nowDate.getMonthValue();
        //System.out.println("nowDate: " + nowDay + ", nowMonth: "+nowMonth);

        if (birthMonth == nowMonth && (nowDay >= birthDay & nowDay <= lastDayOfDiscount.getDayOfMonth())){
            System.out.println("You've got a birthday discount!");
            return DISCOUNT_BIRTHDAY;
        }
        return 0;
    }
}

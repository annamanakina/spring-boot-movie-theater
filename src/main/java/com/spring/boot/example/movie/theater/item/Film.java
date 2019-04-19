package com.spring.boot.example.movie.theater.item;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Film extends Entity{
    private String title;
    private double rating;
    private int duration;

    public Film(int id, String title, double rating, int duration) {
        super(id);
        this.title = title;
        this.rating = rating;
        this.duration = duration;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Film{");
        sb.append("title='").append(title).append('\'');
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }
}

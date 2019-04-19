package com.spring.boot.example.movie.theater.service;


import com.spring.boot.example.movie.theater.dao.AuditoriumDAO;
import com.spring.boot.example.movie.theater.item.Auditorium;

import java.util.Set;

public class AuditoriumService  {
    private AuditoriumDAO auditoriumDAO;

    public AuditoriumService(AuditoriumDAO auditoriumDAO) {
        this.auditoriumDAO = auditoriumDAO;
    }

    public Set<Auditorium> getAuditoriums(){
        return (Set<Auditorium>) auditoriumDAO.getAll();
    }

    public Auditorium getByName(String title){
        return auditoriumDAO.getAll().stream()
                .filter(auditorium -> auditorium.getName().equals(title))
                .findFirst().orElseThrow(() ->new IllegalArgumentException("No such auditorium by title "+ title));
    }
}

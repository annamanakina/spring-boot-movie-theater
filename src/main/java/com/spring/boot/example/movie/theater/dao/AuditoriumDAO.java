package com.spring.boot.example.movie.theater.dao;

import com.spring.boot.example.movie.theater.item.Auditorium;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Set;

@Getter
@Setter
public class AuditoriumDAO extends AbstractDAO<Integer, Auditorium> {

    private Set<Auditorium> auditoriums;

    public AuditoriumDAO(Set<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    @Override
    public Collection<Auditorium> getAll() {
        return auditoriums;
    }

    @Override
    public Auditorium getById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Auditorium object) {
        return false;
    }

    @Override
    public boolean create(Auditorium object) {
        return false;
    }

    @Override
    public Auditorium update(Auditorium object) {
        return null;
    }
}

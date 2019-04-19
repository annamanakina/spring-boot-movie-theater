package com.spring.boot.example.movie.theater.dao;


import com.spring.boot.example.movie.theater.item.Film;

import java.util.Collection;

public class FilmDAO extends AbstractDAO<Integer, Film>{

    private Collection<Film> films;

    public FilmDAO(Collection<Film> films) {
        this.films = films;
    }

    @Override
    public Collection<Film> getAll() {
        return null;
    }

    @Override
    public Film getById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Film object) {
        return false;
    }

    @Override
    public boolean create(Film object) {
        return false;
    }

    @Override
    public Film update(Film object) {
        return null;
    }
}

package com.spring.boot.example.movie.theater.dao;

import com.spring.boot.example.movie.theater.item.Entity;

import java.util.Collection;

public abstract class AbstractDAO <K, T extends Entity> {

    public abstract Collection<T> getAll();
    public abstract T getById(K id);
    public abstract boolean delete (K id);
    public abstract boolean delete (T object);
    public abstract boolean create (T object);
    public abstract T update(T object);
}

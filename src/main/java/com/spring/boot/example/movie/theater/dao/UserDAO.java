package com.spring.boot.example.movie.theater.dao;


import com.spring.boot.example.movie.theater.item.User;

import java.util.Collection;

public class UserDAO extends AbstractDAO<Integer, User> {

    private Collection<User> users;

    public UserDAO(Collection<User> users) {
        this.users = users;
    }

    /*public void setUsers(Collection<User> users) {
        this.users = users;
    }*/

    @Override
    public Collection<User> getAll() {
        return users;
    }

    @Override
    public User getById(Integer id) {
        return users.stream().filter(user -> user.getId() == id)
                .findFirst().orElseThrow(() ->new IllegalArgumentException("No such registered user by id "+ id));
    }

    public User getUserByEmail(String email) {
        return  users.stream().filter(user -> user.getEmail().equals(email))
                     .findFirst().orElseThrow(() ->new IllegalArgumentException("email is not correct or no such registered user"));
    }

    @Override
    public boolean delete(Integer id) {
        return users.removeIf(user -> user.getId() == id);
    }

    @Override
    public boolean delete(User user) {
        return users.removeIf(u -> u.equals(user));
    }

    @Override
    public boolean create(User user) {
        return users.add(user);
    }

    //todo later
    @Override
    public User update(User user) {
        return null;
    }
}

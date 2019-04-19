package com.spring.boot.example.movie.theater.service;

import com.spring.boot.example.movie.theater.dao.UserDAO;
import com.spring.boot.example.movie.theater.item.User;

import java.util.Collection;

public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Collection<User> getUsers(){
        return userDAO.getAll();
    }

    public User getUserByEmail(String email){
        return userDAO.getUserByEmail(email);
    }

    public User getUserById(int id){
        return userDAO.getById(id);
    }

    public boolean remove(int id){
        return userDAO.delete(id);
    }

    public boolean remove(User user){
        return userDAO.delete(user);
    }

    public boolean save(User user){
        return userDAO.create(user);
    }

}

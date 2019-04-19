package com.spring.boot.example.movie.theater.repository;

import com.spring.boot.example.movie.theater.item.UserTest;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
//
public interface UserRepository extends CrudRepository<UserTest, Integer> {
}

package com.spring.boot.example.movie.theater.item;

import com.spring.boot.example.movie.theater.common.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Setter
@Getter
@Entity // This tells Hibernate to make a table out of this class
public class UserTest {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String birthday;
    private String email;
    private String password;
    private UserRole role;

    public UserTest() {
    }
}

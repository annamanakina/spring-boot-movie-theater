package com.spring.boot.example.movie.theater.item;

import com.spring.boot.example.movie.theater.common.UserRole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.NavigableSet;
import java.util.TreeSet;

import javax.persistence.Entity;

@Getter
@Setter
@EqualsAndHashCode
//https://www.youtube.com/watch?v=WDlifgLS8iQ
@Entity // This tells Hibernate to make a table out of this class
public class User {   //extends Entity{
    private LocalDate birthday;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserRole role;
    private NavigableSet<Ticket> tickets = new TreeSet<>();

    public UserRole getRole() {
        return this.role;
    }
    //LocalDate birthday,
    public User(int id,  String firstName, String lastName, String email,
                String password, UserRole role) {
        //super(id);
        //this.birthday = birthday;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("birthday='").append(birthday).append('\'');
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}

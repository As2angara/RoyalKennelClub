package com.adrianangara.shows.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class User {

    private int id;
    private String email;
    private String firstname;
    private String lastname;
    private String password;

    public User(int id, String email, String firstname, String lastname, String password) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }
}

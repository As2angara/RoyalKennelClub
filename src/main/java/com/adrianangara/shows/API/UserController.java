package com.adrianangara.shows.API;

import com.adrianangara.shows.DAO.Interfaces.UserRepository;
import com.adrianangara.shows.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/user", produces="application/json")
@CrossOrigin(origins="*")
public class UserController {

    private final UserRepository ur;

    @Autowired
    public UserController(UserRepository ur) {
        this.ur = ur;
    }





}

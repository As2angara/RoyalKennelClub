package com.adrianangara.shows.API;

import com.adrianangara.shows.DAO.Interfaces.UserRepository;
import com.adrianangara.shows.Models.Contestant;
import com.adrianangara.shows.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user", produces="application/json")
@CrossOrigin(origins="*")
public class UserController {

    private final UserRepository ur;

    @Autowired
    public UserController(UserRepository ur) {
        this.ur = ur;
    }


    //READ Operations
    @GetMapping
    public Iterable<User> getUserTable() {
        return ur.getAll();
    }

    @GetMapping("/{id}")
    public User getUserByID(@PathVariable("id") int id) {
        User user = ur.getById(id);
        return user;
    }

    //CREATE Operations
    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user) {
        return ur.save(user);
    }

    //UPDATE Operations
    @PutMapping("/{id}")
    public User putContestant(@RequestBody User user, @PathVariable("id") int id) {
        return ur.update(user, id);
    }

    //DELETE Operations
    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") int id) {
        try {
            ur.deleteById(id);
        }catch (EmptyResultDataAccessException e){

        }
    }

}

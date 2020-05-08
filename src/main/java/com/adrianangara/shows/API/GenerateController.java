package com.adrianangara.shows.API;

import com.adrianangara.shows.DAO.Interfaces.BreedRepository;
import com.adrianangara.shows.DAO.Interfaces.ContestantRepository;
import com.adrianangara.shows.DAO.Interfaces.UserRepository;
import com.adrianangara.shows.Logic.GenerateContestants;
import com.adrianangara.shows.Logic.GenerateUser;
import com.adrianangara.shows.Models.Breed;
import com.adrianangara.shows.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path="/generate", produces="application/json")
@CrossOrigin(origins="*")
public class GenerateController {

    private final UserRepository ur;
    private final BreedRepository br;
    private final ContestantRepository cr;

    @Autowired
    public GenerateController(UserRepository ur, BreedRepository br,
                              ContestantRepository cr) {

        this.ur = ur;
        this.br = br;
        this.cr = cr;
    }

    //Generate a list of dummy users
    @GetMapping("/users")
    public String generateUsers() {

//        GenerateUser gs = new GenerateUser();
//
//        for (int i = 0; i < 4; i++) {
//            User user = gs.generateUser();
//
//            ur.save(user);
//        }
//
        return "generated";
    }

    @GetMapping("/contestants")
    public String geneerateContestants() {

        //Initialize a GenerateContestants object and breed list
        GenerateContestants gc = new GenerateContestants();
        Iterable<Breed> list = br.getAll();

        //For each user in the list generate 1 or 2 dogs
        for (User user : ur.getAll()) {

            //Generate a Contestant
            if(Math.random() < 0.5) {
                cr.save(gc.generateContestant(user, list));
                cr.save(gc.generateContestant(user, list));
            }else {
                cr.save(gc.generateContestant(user, list));
            }

        }


        return "generated";
    }

}

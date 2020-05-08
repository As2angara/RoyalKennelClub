package com.adrianangara.shows.API;

import com.adrianangara.shows.DAO.Interfaces.*;
import com.adrianangara.shows.Logic.GenerateContestants;
import com.adrianangara.shows.Logic.GenerateShowContestants;
import com.adrianangara.shows.Logic.GenerateUser;
import com.adrianangara.shows.Models.*;
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
    private final ShowRepository sr;
    private final ShowContestantRepository scr;

    @Autowired
    public GenerateController(UserRepository ur, BreedRepository br,
                              ContestantRepository cr, ShowRepository sr,
                              ShowContestantRepository scr) {

        this.ur = ur;
        this.br = br;
        this.cr = cr;
        this.sr = sr;
        this.scr = scr;
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

    //Generate a list of dummy contestants
    @GetMapping("/contestants")
    public String generateContestants() {

//        //Initialize a GenerateContestants object and breed list
//        GenerateContestants gc = new GenerateContestants();
//        Iterable<Breed> list = br.getAll();
//
//        //For each user in the list generate 1 or 2 dogs
//        for (User user : ur.getAll()) {
//
//            //Generate a Contestant
//            if(Math.random() < 0.3) {
//                cr.save(gc.generateContestant(user, list));
//                cr.save(gc.generateContestant(user, list));
//            }else {
//                cr.save(gc.generateContestant(user, list));
//            }
//
//
//        }


        return "generated";
    }

    //Generate a list of dummy show-contestants
    @GetMapping("/show-contestant")
    public String generateShowContestants() {

//        GenerateShowContestants gsc = new GenerateShowContestants();
//
//        Iterable<Show> list_show = sr.getAll();
//        Iterable<Contestant> list_con = cr.getAll();
//
//        for (Contestant con : list_con) {
//
//            ShowContestant scon = gsc.generateShowContestant(list_show, con);
//
//            scr.save(scon);
//        }
//



        return "generated";
    }

}

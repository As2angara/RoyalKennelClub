package com.adrianangara.shows.API;

import com.adrianangara.shows.DAO.ContestantDAO;
import com.adrianangara.shows.DAO.Interfaces.ContestantRepository;
import com.adrianangara.shows.Models.Contestant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/contestants", produces="application/json")
@CrossOrigin(origins="*")
public class ContestantController {

    private final ContestantRepository cr;

    @Autowired
    public ContestantController(ContestantRepository cr) {
        this.cr = cr;
    }

    //READ Operations
    @GetMapping
    public Iterable<Contestant> getContestantTable() {
        return cr.getAll();
    }

    @GetMapping("/{id}")
    public Contestant getContestantByID(@PathVariable("id") int id) {
        Contestant con = cr.getById(id);
        return con;
    }

    //CREATE Operations
    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Contestant postContestant(@RequestBody Contestant con) {
        return cr.save(con);
    }

}


package com.adrianangara.shows.API;

import com.adrianangara.shows.DAO.ContestantDAO;
import com.adrianangara.shows.DAO.Interfaces.ContestantRepository;
import com.adrianangara.shows.DAO.Interfaces.ShowContestantRepository;
import com.adrianangara.shows.Logic.GroupFinder;
import com.adrianangara.shows.Models.Contestant;
import com.adrianangara.shows.Models.ShowContestant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path="/contestants", produces="application/json")
@CrossOrigin(origins="*")
public class ContestantController {

    private final ContestantRepository cr;
    private final ShowContestantRepository scr;

    @Autowired
    public ContestantController(ContestantRepository cr, ShowContestantRepository scr) {

        this.cr = cr;
        this.scr = scr;
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

    @GetMapping("/owner/{ownerId}")
    public Iterable<Contestant> getContestantByOwnerId(@PathVariable("ownerId") int id) {
        return cr.getByOwnerId(id);
    }

    //CREATE Operations
    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Contestant postContestant(@RequestBody Contestant con) {
        GroupFinder gf = new GroupFinder();

        return cr.save(gf.findGroup(con));
    }

    //UPDATE Operations
    @PutMapping("/{id}")
    public Contestant putContestant(@RequestBody Contestant con, @PathVariable("id") int id) {
        GroupFinder gf = new GroupFinder();

        return cr.update(gf.findGroup(con), id);
    }

    //DELETE Operations
    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteContestant(@PathVariable("id") int id) {

        //Get the list of show contestants, and check if it exists.
        Iterable<ShowContestant> list = scr.getAll();

        //If it exists, then remove all from show contestants table
        for (ShowContestant contestant : list) {
            if(contestant.getContestantId() == id) {
                scr.deleteShowCon(contestant);
            }
        }

        //Call the delete method from Contestants repository to delete from DB
        try {
            cr.deleteById(id);
        }catch (EmptyResultDataAccessException e){

        }
    }
}


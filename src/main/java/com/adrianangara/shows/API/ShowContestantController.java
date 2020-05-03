package com.adrianangara.shows.API;

import com.adrianangara.shows.DAO.Interfaces.ShowContestantRepository;
import com.adrianangara.shows.DAO.Interfaces.ShowRepository;
import com.adrianangara.shows.Models.Show;
import com.adrianangara.shows.Models.ShowContestant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/show-contestant", produces="application/json")
@CrossOrigin(origins="*")
public class ShowContestantController {

    private final ShowContestantRepository sr;

    @Autowired
    public ShowContestantController(ShowContestantRepository sr) {
        this.sr = sr;
    }


    //READ Operations
    @GetMapping
    public Iterable<ShowContestant> getShowContestantTable() {
        return sr.getAll();
    }

    //CREATE Operations
    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ShowContestant postShowContestant(@RequestBody ShowContestant con) {
        return sr.save(con);
    }

    //DELETE Operations
    @DeleteMapping(consumes="application/json")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteShowContestant(@RequestBody ShowContestant con) {
        try {
            sr.deleteShowCon(con);
        }catch (EmptyResultDataAccessException e){

        }
    }


}

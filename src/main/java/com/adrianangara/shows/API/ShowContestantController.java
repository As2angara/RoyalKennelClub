package com.adrianangara.shows.API;

import com.adrianangara.shows.DAO.Interfaces.ShowContestantRepository;
import com.adrianangara.shows.DAO.Interfaces.ShowRepository;
import com.adrianangara.shows.Models.Show;
import com.adrianangara.shows.Models.ShowContestant;
import com.adrianangara.shows.Models.ShowContestantFull;
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

    @GetMapping("/full")
    public Iterable<ShowContestantFull> getShowContestantsFull() {
        return sr.getAllFull();
    }

    @GetMapping("/{showId}/{contestantId}")
    public  ShowContestant getShowContestant(@PathVariable("showId") int showId,
                                             @PathVariable("contestantId") int contestantId) {

        ShowContestant con = new ShowContestant(showId, contestantId, 0);

        return sr.getShowContestant(con);
    }

    //CREATE Operations
    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ShowContestant postShowContestant(@RequestBody ShowContestant con) {

        //Get the contestant from the repository to check if it exists
        ShowContestant contestant = null;
        try{
            contestant = sr.getShowContestant(con);
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e);
            contestant = null;
        }



        //If its null save the new contestant
        if (contestant == null) {
            return sr.save(con);
        } else {
            return contestant;
        }

    }

    //DELETE Operations
    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteShowContestant(@PathVariable("id") int id) {
        try {
            sr.deleteShowConById(id);
        }catch (EmptyResultDataAccessException e){

        }
    }


}

package com.adrianangara.shows.API;

import com.adrianangara.shows.DAO.Interfaces.ShowRepository;
import com.adrianangara.shows.Models.Contestant;
import com.adrianangara.shows.Models.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/show", produces="application/json")
@CrossOrigin(origins="*")
public class ShowController {

    private final ShowRepository sr;

    @Autowired
    public ShowController(ShowRepository sr) {
        this.sr = sr;
    }

    //READ Operations
    @GetMapping
    public Iterable<Show> getShowTable() {
        return sr.getAll();
    }

    @GetMapping("/{id}")
    public Show getShowByID(@PathVariable("id") int id) {
        Show show = sr.getById(id);
        return show;
    }

    //CREATE Operations
    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Show postShow(@RequestBody Show show) {
        return sr.save(show);
    }

    //UPDATE Operations
    @PutMapping("/{id}")
    public Show putShow(@RequestBody Show show, @PathVariable("id") int id) {
        return sr.update(show, id);
    }

    //DELETE Operations
    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteShow(@PathVariable("id") int id) {
        try {
            sr.deleteById(id);
        }catch (EmptyResultDataAccessException e){

        }
    }



}

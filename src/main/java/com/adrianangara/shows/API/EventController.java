package com.adrianangara.shows.API;

import com.adrianangara.shows.DAO.Interfaces.EventRepository;
import com.adrianangara.shows.DAO.Interfaces.ShowRepository;
import com.adrianangara.shows.Models.Event;
import com.adrianangara.shows.Models.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/event", produces="application/json")
@CrossOrigin(origins="*")
public class EventController {

    private final EventRepository er;

    @Autowired
    public EventController(EventRepository er) {
        this.er = er;
    }

    //READ Operations
    @GetMapping
    public Iterable<Event> getEventTable() {
        return er.getAll();
    }

    @GetMapping("/{id}")
    public Event getEventByID(@PathVariable("id") int id) {
        Event event = er.getById(id);
        return event;
    }

    //CREATE Operations
    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Event postEvent(@RequestBody Event event) {
        return er.save(event);
    }

    //UPDATE Operations
    @PutMapping("/{id}")
    public Event putEvent(@RequestBody Event event, @PathVariable("id") int id) {
        return er.update(event, id);
    }

    //DELETE Operations
    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteEvent(@PathVariable("id") int id) {
        try {
            er.deleteById(id);
        }catch (EmptyResultDataAccessException e){

        }
    }
}

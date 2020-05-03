package com.adrianangara.shows.DAO.Interfaces;

import com.adrianangara.shows.Models.Event;

public interface EventRepository {

    Iterable<Event> getAll();
    Event getById(int id);
    Event save(Event event);
    Event update(Event event, int id);
    void deleteById(int id);
}

package com.adrianangara.shows.DAO.Interfaces;

import com.adrianangara.shows.Models.Show;
import com.adrianangara.shows.Models.User;

public interface ShowRepository {

    Iterable<Show> getAll();
    Show getById(int id);
    Show save(Show show);
    Show update(Show show, int id);
    void deleteById(int id);
}

package com.adrianangara.shows.DAO.Interfaces;

import com.adrianangara.shows.Models.Contestant;

import java.util.ArrayList;

public interface ContestantRepository {

    Iterable<Contestant> getAll();
    Contestant getById(int id);
    Contestant save(Contestant con);
}

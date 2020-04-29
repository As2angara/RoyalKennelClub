package com.adrianangara.shows.DAO.Interfaces;

import com.adrianangara.shows.Models.Contestant;
import com.adrianangara.shows.Models.ShowContestant;

public interface ShowContestantRepository {

    Iterable<ShowContestant> getAll();
    ShowContestant save(ShowContestant con);
    void deleteById(int id);
}

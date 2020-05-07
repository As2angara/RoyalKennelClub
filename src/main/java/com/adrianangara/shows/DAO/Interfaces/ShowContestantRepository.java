package com.adrianangara.shows.DAO.Interfaces;

import com.adrianangara.shows.Models.Contestant;
import com.adrianangara.shows.Models.ShowContestant;

public interface ShowContestantRepository {

    Iterable<ShowContestant> getAll();
    ShowContestant getShowContestant(ShowContestant con);
    ShowContestant save(ShowContestant con);
    void deleteShowCon(ShowContestant con);
    void deleteShowConById(int id);
}

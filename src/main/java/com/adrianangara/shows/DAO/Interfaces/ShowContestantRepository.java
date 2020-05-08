package com.adrianangara.shows.DAO.Interfaces;

import com.adrianangara.shows.Models.Contestant;
import com.adrianangara.shows.Models.ShowContestant;
import com.adrianangara.shows.Models.ShowContestantFull;

public interface ShowContestantRepository {

    Iterable<ShowContestant> getAll();
    ShowContestant getShowContestant(ShowContestant con);
    Iterable<ShowContestantFull> getAllFull();
    ShowContestant save(ShowContestant con);
    void deleteShowCon(ShowContestant con);
    void deleteShowConById(int id);
}

package com.adrianangara.shows.Models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ShowContestant {

    private int showId;
    private int contestantId;
    private int id;

    public ShowContestant(int show_id, int contestant_id, int id) {
        this.showId = show_id;
        this.contestantId = contestant_id;
        this.id = id;
    }
}

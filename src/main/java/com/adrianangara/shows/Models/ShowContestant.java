package com.adrianangara.shows.Models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ShowContestant {

    public int showId;
    public int contestantId;

    public ShowContestant(int show_id, int contestant_id) {
        this.showId = show_id;
        this.contestantId = contestant_id;
    }
}

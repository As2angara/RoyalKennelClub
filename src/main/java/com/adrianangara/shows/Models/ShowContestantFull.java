package com.adrianangara.shows.Models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ShowContestantFull {

    private int contestantId;
    private int showId;
    private String firstname;
    private String lastname;
    private String name;
    private String breed;
    private String group;
    private boolean isMale;
    private boolean isSpecial;

    public ShowContestantFull(int contestant_id, int show_id, String firstname,
                              String lastname, String name, String breed, String dog_group,
                              boolean isMale, boolean isSpecial)
    {
        this.contestantId = contestant_id;
        this.showId = show_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.name = name;
        this.breed = breed;
        this.group = dog_group;
        this.isMale = isMale;
        this.isSpecial = isSpecial;
    }
}

package com.adrianangara.shows.Logic;

import com.adrianangara.shows.Models.Contestant;
import com.adrianangara.shows.Models.Show;
import com.adrianangara.shows.Models.ShowContestant;

import java.util.Collection;

public class GenerateShowContestants {

    public ShowContestant generateShowContestant(Iterable<Show> list_show, Contestant con) {

        //Initiate needed fields for ShowContestant object
        int showId = 0;
        int contestantId = 0;

        //Generate a random number from 1 to the size of the iterable
        int rn_show = (int)Math.floor(Math.random() * size(list_show)) + 1;


        //Iterate through the show list and assign a random show to contestant
        int i = 1;

        for (Show show : list_show) {
            if(rn_show == i) {
                showId = show.getId();
                contestantId = con.getId();
                break;
            }
            i++;
        }

        return new ShowContestant(showId, contestantId, 0);

    }

    public static int size(Iterable data) {

        if (data instanceof Collection) {
            return ((Collection<?>) data).size();
        }
        int counter = 0;
        for (Object i : data) {
            counter++;
        }
        return counter;
    }
}

package com.adrianangara.shows.Logic;

import com.adrianangara.shows.Enum.DogName;
import com.adrianangara.shows.Enum.Firstname;
import com.adrianangara.shows.Models.Breed;
import com.adrianangara.shows.Models.Contestant;
import com.adrianangara.shows.Models.User;

public class GenerateContestants {

    public Contestant generateContestant(User user, Iterable<Breed> list ) {

        //Initialize variables
        String name = "";
        int ownerId = user.getId();
        String breed = "";
        String group = "";
        boolean isMale = true;
        boolean isSpecial;

        //Generate Random Dog Name + Gender
        int rn1 = (int)Math.floor(Math.random() * 18) + 1;
        for(DogName n: DogName.values()) {
            if(rn1 == n.getID()) {
                name = n.printDogName();
                isMale = n.printGender();
                break;
            }
        }

        //Generate a random breed
        int rn3 = (int)Math.floor(Math.random() * 21) + 1;

        int i = 0;
        for (Breed brd : list) {
            if(rn3 == i) {
                breed = brd.getName();
                group = brd.getBreed_group();
                break;
            }
            i++;
        }


        //Generate Random Rank
        if(Math.random() < 0.5) {
            isSpecial = true;
        }else {
            isSpecial = false;
        }

        return new Contestant(0, name, ownerId, breed, group, isMale, isSpecial);

    }
}

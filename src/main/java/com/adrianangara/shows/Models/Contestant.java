package com.adrianangara.shows.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class Contestant {

    public int id;
    public String name;
    public int ownerId;
    public String breed;
    public String group;
    public boolean isMale;
    public boolean isSpecial;

    public Contestant(int id, String name, int ownerId, String breed, String group,
                      boolean isMale, boolean isSpecial) {
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
        this.breed = breed;
        this.group = group;
        this.isMale = isMale;
        this.isSpecial = isSpecial;
    }

    public boolean getIsMale() {
        return isMale;
    }

    public boolean getIsSpecial() {
        return isSpecial;
    }
}

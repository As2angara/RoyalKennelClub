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
    public String ownerName;
    public String breed;
    public String group;
    public boolean isMale;
    public boolean isSpecial;

    public Contestant(int id, String name, String ownerName, String breed, String group,
                      boolean isMale, boolean isSpecial) {
        this.id = id;
        this.name = name;
        this.ownerName = ownerName;
        this.breed = breed;
        this.group = group;
        this.isMale = isMale;
        this.isSpecial = isSpecial;
    }
}

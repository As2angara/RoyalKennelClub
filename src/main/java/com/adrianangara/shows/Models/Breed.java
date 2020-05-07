package com.adrianangara.shows.Models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Breed {
    private int id;
    private String life_span;
    private String name;
    private String origin;
    private String temperament;
    private String bred_for;
    private String breed_group;
    private String country_code;
    private Measurement height;
    private Measurement weight;
    private String pic_url;

    public Breed(int id, String life_span, String name, String origin, String temperament,
                 String bred_for, String breed_group, String country_code, Measurement height,
                 Measurement weight,
                 String pic_url)
    {
        this.id = id;
        this.life_span = life_span;
        this.name = name;
        this.origin = origin;
        this.temperament = temperament;
        this.bred_for = bred_for;
        this.breed_group = breed_group;
        this.country_code = country_code;
        this.height = height;
        this.weight = weight;
        this.pic_url = pic_url;
    }
}

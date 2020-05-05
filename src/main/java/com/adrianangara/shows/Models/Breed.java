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
}

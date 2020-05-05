package com.adrianangara.shows.Services;

import com.adrianangara.shows.Models.Breed;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class BreedService {

    private RestTemplate rest = new RestTemplate();


    public Breed[] getBreeds() {
        return rest.getForObject("https://api.thedogapi.com/v1/breeds", Breed[].class);
    }


}

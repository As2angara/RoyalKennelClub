package com.adrianangara.shows.API;

import com.adrianangara.shows.DAO.Interfaces.BreedRepository;
import com.adrianangara.shows.DAO.Interfaces.ContestantRepository;
import com.adrianangara.shows.Models.Breed;
import com.adrianangara.shows.Models.BreedPic;
import com.adrianangara.shows.Models.Contestant;
import com.adrianangara.shows.Services.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path="/breeds", produces="application/json")
@CrossOrigin(origins="*")
public class BreedController {

    private final BreedRepository br;

    @Autowired
    public BreedController(BreedRepository br) {
        this.br = br;
    }

    //READ Operations
    @GetMapping
    public void getBreedsPicTable() {
        BreedService bs = new BreedService();
        ArrayList<Breed> pics = new ArrayList<Breed>();

        for (Breed breed: bs.getBreeds()) {

            for (BreedPic pic: br.getAll()) {

                if(breed.getId() == pic.getId()) {
                    breed.setPic_url(pic.getPic_url());
                    br.save(breed);
                }
            }
        }



    }

    @GetMapping("/fromapi")
    public void getBreeds() {
        BreedService bs = new BreedService();

        for (Breed breed: bs.getBreeds()) {
            System.out.println( breed.getId() + ": " +breed.getName());
        }

    }
}

package com.adrianangara.shows.API;

import com.adrianangara.shows.DAO.Interfaces.BreedRepository;
import com.adrianangara.shows.DAO.Interfaces.ContestantRepository;
import com.adrianangara.shows.Models.BreedPic;
import com.adrianangara.shows.Models.Contestant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Iterable<BreedPic> getBreedsPicTable() {
        return br.getAll();
    }
}

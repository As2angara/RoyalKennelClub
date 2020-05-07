package com.adrianangara.shows.DAO.Interfaces;

import com.adrianangara.shows.Models.Breed;
import com.adrianangara.shows.Models.BreedPic;

public interface BreedRepository {
    Iterable<BreedPic> getAll();
    Breed save(Breed breed);
}

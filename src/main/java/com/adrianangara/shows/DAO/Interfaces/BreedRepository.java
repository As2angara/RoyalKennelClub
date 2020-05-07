package com.adrianangara.shows.DAO.Interfaces;

import com.adrianangara.shows.Models.Breed;

public interface BreedRepository {
    Iterable<Breed> getAll();
    Breed save(Breed breed);
}

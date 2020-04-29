package com.adrianangara.shows.DAO.Interfaces;

import com.adrianangara.shows.Models.Contestant;
import com.adrianangara.shows.Models.User;

public interface UserRepository {

    Iterable<User> getAll();
    User getById(int id);
    User save(User user);
    User update(User user, int id);
    void deleteById(int id);
}

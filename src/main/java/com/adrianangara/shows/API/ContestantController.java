package com.adrianangara.shows.API;

import com.adrianangara.shows.DAO.ContestantDAO;
import com.adrianangara.shows.DAO.Interfaces.ContestantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ContestantController {

    private final ContestantRepository cr;

    @Autowired
    public ContestantController(ContestantRepository cr) {
        this.cr = cr;
    }

    @GetMapping
    public void getContestantTable() {
        cr.getAll().forEach(i -> System.out.println(i.name));
    }


}


package com.adrianangara.shows.DAO;

import com.adrianangara.shows.DAO.Interfaces.BreedRepository;
import com.adrianangara.shows.Models.Breed;
import com.adrianangara.shows.Models.BreedPic;
import com.adrianangara.shows.Models.Contestant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class BreedDAO implements BreedRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public BreedDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<BreedPic> getAll() {
        return jdbc.query("select * from Breeds_Pic",
                this::mapRowToBreedsPic);
    }

    @Override
    public Breed save(Breed breed) {
        jdbc.update("insert into Breed (id, name, life_span, origin, temperament, bred_for," +
                        "breed_group, country_code, height_imp, height_met, weight_imp, weight_met, pic_url) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                breed.getId(),
                breed.getName(),
                breed.getLife_span(),
                breed.getOrigin(),
                breed.getTemperament(),
                breed.getBred_for(),
                breed.getBreed_group(),
                breed.getCountry_code(),
                breed.getHeight().getImperial(),
                breed.getHeight().getMetric(),
                breed.getWeight().getImperial(),
                breed.getWeight().getMetric(),
                breed.getPic_url()
        );

        return breed;
    }

    private BreedPic mapRowToBreedsPic(ResultSet rs, int rowNum) throws SQLException {

        return new BreedPic(
                rs.getInt("id"),
                rs.getString("pic_url")
        );

    }
}

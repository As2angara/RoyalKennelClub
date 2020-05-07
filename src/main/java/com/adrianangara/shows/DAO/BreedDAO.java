package com.adrianangara.shows.DAO;

import com.adrianangara.shows.DAO.Interfaces.BreedRepository;
import com.adrianangara.shows.Models.Breed;
import com.adrianangara.shows.Models.Measurement;
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
    public Iterable<Breed> getAll() {
        return jdbc.query("select * from Breed",
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

    private Breed mapRowToBreedsPic(ResultSet rs, int rowNum) throws SQLException {

        return new Breed(
                rs.getInt("id"),
                rs.getString("life_span"),
                rs.getString("name"),
                rs.getString("origin"),
                rs.getString("temperament"),
                rs.getString("bred_for"),
                rs.getString("breed_group"),
                rs.getString("country_code"),
                new Measurement(rs.getString("height_imp"), rs.getString("height_met")),
                new Measurement(rs.getString("weight_imp"), rs.getString("weight_met")),
                rs.getString("pic_url")
        );

    }
}

package com.adrianangara.shows.DAO;

import com.adrianangara.shows.DAO.Interfaces.BreedRepository;
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

    private BreedPic mapRowToBreedsPic(ResultSet rs, int rowNum) throws SQLException {

        return new BreedPic(
                rs.getInt("id"),
                rs.getString("pic_url")
        );

    }
}

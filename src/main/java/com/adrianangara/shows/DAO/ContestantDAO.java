package com.adrianangara.shows.DAO;

import com.adrianangara.shows.DAO.Interfaces.ContestantRepository;
import com.adrianangara.shows.Models.Contestant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.Types;
import java.sql.SQLException;
import java.util.ArrayList;


@Repository
public class ContestantDAO implements ContestantRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public ContestantDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Contestant> getAll() {
        return jdbc.query("select * from Contestant",
                this::mapRowToContestant);
    }

    @Override
    public Contestant getById(int id) {
        return jdbc.queryForObject("select * from Contestant where id=?",
                this::mapRowToContestant, id);
    }

    @Override
    public Iterable<Contestant> getByOwnerId(int id) {
        return jdbc.query("select * from Contestant where owner_id=?",
                this::mapRowToContestant, id);
    }

    @Override
    public Contestant save(Contestant con) {
        jdbc.update("insert into Contestant (name, owner_id, breed, dog_group, isMale, isSpecial) " +
                "values (?, ?, ?, ?, ?, ?)",
                con.getName(),
                con.getOwnerId(),
                con.getBreed(),
                con.getGroup(),
                con.getIsMale(),
                con.getIsSpecial()
                );

        return con;
    }

    @Override
    public Contestant update(Contestant con, int id) {

        jdbc.update("update Contestant set name=?, owner_id=?, breed=?, dog_group=?, isMale=?, isSpecial=?" +
                " where id=" + id,
                con.getName(),
                con.getOwnerId(),
                con.getBreed(),
                con.getGroup(),
                con.getIsMale(),
                con.getIsSpecial());

        return con;
    }

    @Override
    public void deleteById(int id) {
        int rows = jdbc.update("delete from Contestant where id=" + id);
    }

    private Contestant mapRowToContestant(ResultSet rs, int rowNum) throws SQLException {

        return new Contestant(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("owner_id"),
                rs.getString("breed"),
                rs.getString("dog_group"),
                rs.getBoolean("isMale"),
                rs.getBoolean("isSpecial")
        );

    }

}

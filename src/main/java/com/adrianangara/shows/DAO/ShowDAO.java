package com.adrianangara.shows.DAO;

import com.adrianangara.shows.DAO.Interfaces.ShowRepository;
import com.adrianangara.shows.Models.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

@Repository
public class ShowDAO implements ShowRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public ShowDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Show> getAll() {
        return jdbc.query("select * from S_Show",
                this::mapRowToShow);
    }

    @Override
    public Show getById(int id) {
        return jdbc.queryForObject("select * from S_Show where id=?",
                this::mapRowToShow, id);
    }

    @Override
    public Show save(Show show) {
        jdbc.update("insert into S_Show (show_date, location, show_type) " +
                        "values (?, ?, ?)",
                new Date(show.getDate()),
                show.getLocation(),
                show.getType().toString()
        );

        return show;
    }

    @Override
    public Show update(Show show, int id) {

        jdbc.update("update S_User set show_date=?, location=?, show_type=?" +
                        " where id=" + id,
                new Date(show.getDate()),
                show.getLocation(),
                show.getType().toString()
        );

        return show;
    }

    @Override
    public void deleteById(int id) {
        int rows = jdbc.update("delete from S_Show where id=" + id);
    }

    private Show mapRowToShow(ResultSet rs, int rowNum) throws SQLException {

        return new Show(
                rs.getInt("id"),
                rs.getDate("show_date").getTime(),
                rs.getString("location"),
                Show.Type.valueOf(rs.getString("show_type"))
        );

    }

}

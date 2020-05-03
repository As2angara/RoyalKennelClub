package com.adrianangara.shows.DAO;

import com.adrianangara.shows.DAO.Interfaces.EventRepository;
import com.adrianangara.shows.Models.Event;
import com.adrianangara.shows.Models.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class EventDAO implements EventRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public EventDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Event> getAll() {
        return jdbc.query("select * from S_Event",
                this::mapRowToEvent);
    }

    @Override
    public Event getById(int id) {
        return jdbc.queryForObject("select * from S_Event where id=?",
                this::mapRowToEvent, id);
    }

    @Override
    public Event save(Event event) {
        jdbc.update("insert into S_Event (name, location, venue) " +
                        "values (?, ?, ?)",
                event.getName(),
                event.getLocation(),
                event.getVenue()
        );

        return event;
    }

    @Override
    public Event update(Event event, int id) {

        jdbc.update("update S_Event set name=?, location=?, venue=?" +
                        " where id=" + id,
                event.getName(),
                event.getLocation(),
                event.getVenue()
        );

        return event;
    }

    @Override
    public void deleteById(int id) {
        int rows = jdbc.update("delete from S_Event where id=" + id);
    }

    private Event mapRowToEvent(ResultSet rs, int rowNum) throws SQLException {

        return new Event(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("location"),
                rs.getString("venue")
        );

    }
}

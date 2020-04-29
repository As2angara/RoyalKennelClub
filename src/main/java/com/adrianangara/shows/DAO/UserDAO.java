package com.adrianangara.shows.DAO;

import com.adrianangara.shows.DAO.Interfaces.UserRepository;
import com.adrianangara.shows.Models.Contestant;
import com.adrianangara.shows.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDAO implements UserRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public UserDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<User> getAll() {
        return jdbc.query("select * from S_User",
                this::mapRowToContestant);
    }

    @Override
    public User getById(int id) {
        return jdbc.queryForObject("select * from S_User where id=?",
                this::mapRowToContestant, id);
    }

    @Override
    public User save(User user) {
        jdbc.update("insert into S_User (email, firstname, lastname, password) " +
                        "values (?, ?, ?, ?)",
                user.getEmail(),
                user.getFirstname(),
                user.getLastname(),
                user.getPassword()
        );

        return user;
    }

    @Override
    public User update(User user, int id) {

        jdbc.update("insert into S_User (email, firstname, lastname, password) " +
                        "values (?, ?, ?, ?)",
                user.getEmail(),
                user.getFirstname(),
                user.getLastname(),
                user.getPassword()
        );

        return user;
    }

    @Override
    public void deleteById(int id) {
        int rows = jdbc.update("delete from S_User where id=" + id);
    }

    private User mapRowToContestant(ResultSet rs, int rowNum) throws SQLException {

        return new User(
                rs.getInt("id"),
                rs.getString("email"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("password")
        );

    }

}

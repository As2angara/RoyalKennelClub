package com.adrianangara.shows.DAO;

import com.adrianangara.shows.DAO.Interfaces.ShowContestantRepository;
import com.adrianangara.shows.Models.Contestant;
import com.adrianangara.shows.Models.ShowContestant;
import com.adrianangara.shows.Models.ShowContestantFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ShowContestantDAO implements ShowContestantRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public ShowContestantDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    //Read Operations
    @Override
    public Iterable<ShowContestantFull> getAllFull() {
        return jdbc.query("select sc.contestant_id, sc.show_id, o.firstname, o.lastname, " +
                        "c.name, c.breed, c.dog_group, c.isMale, c.isSpecial " +
                        "from s_user as o " +
                        "inner join contestant as c " +
                        "on o.id = c.owner_id " +
                        "inner join show_contestant as sc " +
                        "on c.id = sc.contestant_id;",
                this::mapRowToShowContestantFull);
    }

    @Override
    public ShowContestant getShowContestant(ShowContestant con) {
        return jdbc.queryForObject("select * from Show_Contestant where show_id = ? and contestant_id = ?",
                this::mapRowToShowContestant,
                con.getShowId(),
                con.getContestantId());
    }

    @Override
    public Iterable<ShowContestant> getAll() {
        return jdbc.query("select * from Show_Contestant",
                this::mapRowToShowContestant);
    }

    //Create Operations
    @Override
    public ShowContestant save(ShowContestant con) {
        jdbc.update("insert into Show_Contestant (show_id, contestant_id) " +
                        "values (?, ?)",
                con.getShowId(),
                con.getContestantId()
        );

        return con;
    }

    //Delete Operations
    @Override
    public void deleteShowCon(ShowContestant con) {
        int rows = jdbc.update("delete from Show_Contestant where show_id=? and contestant_id=? ",
                con.getShowId(),
                con.getContestantId()
                );
    }

    @Override
    public void deleteShowConById(int id) {
        jdbc.update("delete from Show_Contestant where id=?", id);
    }

    //Mapping function
    private ShowContestant mapRowToShowContestant(ResultSet rs, int rowNum) throws SQLException {

        return new ShowContestant(
                rs.getInt("show_id"),
                rs.getInt("contestant_id"),
                rs.getInt("id")
        );

    }

    private ShowContestantFull mapRowToShowContestantFull(ResultSet rs, int rowNum) throws SQLException {

        return new ShowContestantFull(
                rs.getInt("contestant_id"),
                rs.getInt("show_id"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("name"),
                rs.getString("breed"),
                rs.getString("dog_group"),
                rs.getBoolean("isMale"),
                rs.getBoolean("isSpecial")
        );

    }

}

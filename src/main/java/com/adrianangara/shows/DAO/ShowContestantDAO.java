package com.adrianangara.shows.DAO;

import com.adrianangara.shows.DAO.Interfaces.ShowContestantRepository;
import com.adrianangara.shows.Models.Contestant;
import com.adrianangara.shows.Models.ShowContestant;
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

    @Override
    public Iterable<ShowContestant> getAll() {
        return jdbc.query("select * from Show_Contestant",
                this::mapRowToShowContestant);
    }

    @Override
    public ShowContestant save(ShowContestant con) {
        jdbc.update("insert into Show_Contestant (show_id, contestant_id) " +
                        "values (?, ?)",
                con.getShowId(),
                con.getContestantId()
        );

        return con;
    }

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

    private ShowContestant mapRowToShowContestant(ResultSet rs, int rowNum) throws SQLException {

        return new ShowContestant(
                rs.getInt("show_id"),
                rs.getInt("contestant_id"),
                rs.getInt("id")
        );

    }

}

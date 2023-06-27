package main.Dao;

import main.model.FootballPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FootballPersonDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FootballPersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<FootballPerson> index() {
        return jdbcTemplate.query("SELECT * FROM football", new BeanPropertyRowMapper<>(FootballPerson.class));
    }

    public FootballPerson show(int id) {
        return jdbcTemplate.query("SELECT * FROM football WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(FootballPerson.class)).stream().findAny().orElse(null);
    }

    public void create(FootballPerson footballPerson) {
        jdbcTemplate.update("INSERT INTO football VALUES (1,?,?,?,?,?)",footballPerson.getName(),footballPerson.getSurname(),footballPerson.getClub(),footballPerson.gettShirtNumber(),footballPerson.getAge());
    }

    public void update(int id, FootballPerson updatedFootballer) {
       jdbcTemplate.update("UPDATE football SET club=?, surname=?, tShirtNumber=? WHERE id=?",updatedFootballer.getClub(), updatedFootballer.getSurname(), updatedFootballer.gettShirtNumber(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM football WHERE id=?",id);
    }
}

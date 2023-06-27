package main.Dao;

import main.model.FootballPerson;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FootballPersonMapper implements RowMapper<FootballPerson> {
    @Override
    public FootballPerson mapRow(ResultSet resultSet, int rowNum) throws SQLException {

       FootballPerson footballPerson = new FootballPerson();

        footballPerson.setId(resultSet.getInt("id"));
        footballPerson.setName(resultSet.getString("name"));
        footballPerson.setSurname(resultSet.getString("surname"));
        footballPerson.setClub(resultSet.getString("club"));
        footballPerson.settShirtNumber(resultSet.getInt("tShirtNumber"));
        footballPerson.setAge(resultSet.getInt("age"));

        return footballPerson;
    }
}

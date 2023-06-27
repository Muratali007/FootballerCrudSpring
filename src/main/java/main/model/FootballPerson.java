package main.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class FootballPerson {
    private Integer id;

    @NotEmpty(message = "name not should be empty")
    @Size(min = 2, max = 30, message = "name should be between 2 and 30 character")
    private String name;

    @NotEmpty(message = "surname not should be empty")
    @Size(min = 2, max = 30, message = "surname should be between 2 and 30 character")
    private String surname;

    @NotEmpty(message = " club not should be empty, at least write free agent")
    @Size(min = 2, max = 30, message = "club should be between 2 and 30 character")
    private String club;

    @Min(value = 0, message = "Age should be greater than 0")
    private Integer age;

    @Min(value = 0, message = "tShirtNumber should be greater than 0")
    private Integer tShirtNumber;

    public FootballPerson() {
    }

    public FootballPerson(Integer id, String name, String surname, String club, Integer age, Integer tShirtNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.club = club;
        this.age = age;
        this.tShirtNumber = tShirtNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public Integer gettShirtNumber() {
        return tShirtNumber;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void settShirtNumber(Integer tShirtNumber) {
        this.tShirtNumber = tShirtNumber;
    }
}

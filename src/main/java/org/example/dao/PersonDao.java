package org.example.dao;

import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM people", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(Long id) {
        return jdbcTemplate.query("SELECT * FROM people WHERE id = ?",
                new BeanPropertyRowMapper<>(Person.class), id).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO people (name, surname, age, email, address) VALUES (?, ?, ?, ?, ?)",
                person.getName(), person.getSurname(), person.getAge(), person.getEmail(), person.getAddress());
    }

    public void update(Long id, Person person) {
        jdbcTemplate.update("UPDATE people SET name = ?, surname = ?, age = ?, email = ?, address = ? WHERE id = ?",
                person.getName(), person.getSurname(), person.getAge(), person.getEmail(), person.getAddress(), id);
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM people WHERE id = ?", id);
    }
}

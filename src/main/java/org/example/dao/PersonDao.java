package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {

    private int personCount;
    private List<Person> people;

    {
        people = new ArrayList<>(List.of(
                new Person(++personCount, "Tom"),
                new Person(++personCount, "Bob"),
                new Person(++personCount, "Evgeniy"),
                new Person(++personCount, "Pavel")
        ));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(p -> p.getId() == id)
                .findAny()
                .orElse(null);
    }
}

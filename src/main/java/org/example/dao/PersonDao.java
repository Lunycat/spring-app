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
                new Person(++personCount, "Tom", "Tomi4", "dsada@mail.ru"),
                new Person(++personCount, "Bob", "Bobi4", "dsada@mail.ru"),
                new Person(++personCount, "Evgeniy", "Evgenievi4", "dsada@mail.ru"),
                new Person(++personCount, "Pavel", "Pavlovi4", "dsada@mail.ru")
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

    public void save(Person person) {
        person.setId(++personCount);
        people.add(person);
    }

    public void save(Person person, int id) {
        people.set((int)(id - 1), person);
    }

    public void update(Person data, int id) {
        Person person = show(id);
        if (!data.getName().isEmpty()) {
            person.setName(data.getName());
        }
        if (!data.getSurname().isEmpty()) {
            person.setSurname(data.getSurname());
        }
        if (!data.getEmail().isEmpty()) {
            person.setEmail(data.getEmail());
        }
        save(person, id);
    }

    public String delete(int id) {
        people.removeIf(p -> p.getId() == id);
        return "redirect:/people";
    }
}

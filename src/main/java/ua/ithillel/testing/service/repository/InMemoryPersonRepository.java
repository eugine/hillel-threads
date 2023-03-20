package ua.ithillel.testing.service.repository;

import ua.ithillel.testing.service.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryPersonRepository implements PersonRepository {
    private final List<Person> db = new ArrayList<>();

    @Override
    public Person findById(String id) {
        return db.stream()
                .filter(person -> Objects.equals(id, person.id()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Person person) {
        Optional.ofNullable(findById(person.id()))
                        .ifPresent(db::remove);
        db.add(person);
    }

    @Override
    public Person delete(String id) {
        var person = findById(id);
        if (person != null) {
            db.remove(person);
        }
        return person;
    }

    @Override
    public String toString() {
        return db.stream()
                .map(Person::toString)
                .collect(Collectors.joining("\n"));
    }
}

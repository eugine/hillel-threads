package ua.ithillel.testing.service.repository;

import ua.ithillel.testing.service.Person;

public interface PersonRepository {
    Person findById(String id);

    void save(Person person);

    Person delete(String id);
}

package ua.ithillel.testing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ithillel.testing.service.event.Event;
import ua.ithillel.testing.service.repository.PersonRepository;

import static org.mockito.Mockito.mock;
import static ua.ithillel.testing.service.event.EventType.PERSON_CREATED;

class PersonServiceTest {
    private PersonRepository personRepository;
    private PersonService personService;

    @BeforeEach
    void setUp() {
        personRepository = mock(PersonRepository.class);
        personService = new PersonService(personRepository);
    }

    @Test
    void shouldCreateNewPerson() {
        var person = new Person("petro1", "Petro");
        personService.process(new Event(PERSON_CREATED, person));
    }
}
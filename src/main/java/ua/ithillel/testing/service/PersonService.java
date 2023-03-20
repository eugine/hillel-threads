package ua.ithillel.testing.service;

import ua.ithillel.testing.service.event.Event;
import ua.ithillel.testing.service.repository.PersonRepository;

import static ua.ithillel.utils.LogUtils.log;

public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void process(Event event) {
        log("Processing event %s", event);
        switch (event.type()) {
            case PERSON_CREATED -> personRepository.save(event.person());
            case PERSON_DELETED -> personRepository.delete(event.person().id());
        }
    }

}

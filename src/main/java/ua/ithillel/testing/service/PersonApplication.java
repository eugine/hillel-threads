package ua.ithillel.testing.service;

import ua.ithillel.testing.service.repository.InMemoryPersonRepository;
import ua.ithillel.testing.service.event.Event;
import ua.ithillel.utils.LogUtils;

import static ua.ithillel.testing.service.event.EventType.PERSON_CREATED;
import static ua.ithillel.testing.service.event.EventType.PERSON_DELETED;

public class PersonApplication {
    public static void main(String[] args) {
        var repository = new InMemoryPersonRepository();
        var service = new PersonService(repository);

        service.process(new Event(PERSON_CREATED, new Person("petro1", "Petro")));
        service.process(new Event(PERSON_CREATED, new Person("maria2", "Maria")));
        service.process(new Event(PERSON_CREATED, new Person("max3", "Maxim")));

        LogUtils.log("Repository:\n%s", repository);

        service.process(new Event(PERSON_DELETED, new Person("max3", "Maxim")));
        LogUtils.log("Repository:\n%s", repository);
    }
}

package ua.ithillel.testing.service.event;

import ua.ithillel.testing.service.Person;

public record Event(
        EventType type,
        Person person) {
}

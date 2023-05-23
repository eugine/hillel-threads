package ua.ithillel.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.ithillel.bank.repository.Person;
import ua.ithillel.bank.repository.PersonRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<PersonDto> findPersons(Pageable pageable) {
        return personRepository.findAll(pageable).stream()
                .map(this::mapPerson)
                .toList();
    }

    public PersonDto findPerson(String id) {
        return personRepository.findByUid(id)
                .map(this::mapPerson)
                .orElseThrow();
    }

    public void deletePerson(String uid) {
        var person =  personRepository.findByUid(uid).orElseThrow();
        personRepository.delete(person);
    }

    public PersonDto updatePerson(String uid, PersonDto person) {
        var personToUpdate = personRepository.findByUid(uid).orElseThrow();
        personToUpdate.setName(person.name());
        personToUpdate.setEmail(person.email());
        return mapPerson(personRepository.save(personToUpdate));
    }

    private PersonDto mapPerson(Person person) {
        return PersonDto.builder()
                .id(person.getUid())
                .name(person.getName())
                .email(person.getEmail())
                .build();
    }

    public PersonDto create(PersonDto person) {
        var savedPerson = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name(person.name())
                .email(person.email())
                .build());
        return mapPerson(savedPerson);
    }
}

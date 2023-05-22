package ua.ithillel.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.ithillel.bank.repository.Person;
import ua.ithillel.bank.repository.PersonRepository;
import ua.ithillel.bank.service.dto.PersonDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<PersonDto> persons(String name, String email, Pageable pageable) {
        var spec = Specification.<Person>where(null);
        if (name != null) {
            spec = spec.and(equalQuery("name", name));
        }
        if (email != null) {
            spec = spec.and(equalQuery("email", email));
        }
        return personRepository.findAll(spec, pageable).stream()
                .map(this::toDto)
                .toList();
    }

    private Specification<Person> equalQuery(String fieldName, String fieldValue) {
        return (root, query, cb) -> cb.equal(root.get(fieldName), fieldValue);
    }

    private PersonDto toDto(Person person) {
        return PersonDto.builder()
                .name(person.getName())
                .email(person.getEmail())
                .build();
    }
}

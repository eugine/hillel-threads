package ua.ithillel.bank;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.bank.service.PersonDto;
import ua.ithillel.bank.service.PersonService;

import java.util.List;

// POST /api/persons/{personId}/accounts/{accountId}

// GET /api/accounts


@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/{id}")
    public PersonDto getPerson(@PathVariable("id") String id) {
        return personService.findPerson(id);
    }

    @GetMapping
    public List<PersonDto> getPersons(Pageable pageable) {
        return personService.findPersons(pageable);
    }

    @PostMapping
    public PersonDto createPerson(@RequestBody PersonDto person) {
        return personService.create(person);
    }

    @PutMapping("/{id}")
    public PersonDto updatePerson(@PathVariable("id") String id, @RequestBody PersonDto person) {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") String id) {
        personService.deletePerson(id);
    }

}

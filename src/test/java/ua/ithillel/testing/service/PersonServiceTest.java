package ua.ithillel.testing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.ithillel.bank.credit.score.CreditScoreService;
import ua.ithillel.testing.service.repository.PersonRepository;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;
    @Mock
    private CreditScoreService creditScoreService;
    private PersonService target;

    @BeforeEach
    void setUp() {
        target = new PersonService(personRepository);
    }

    @Test
    void shouldCreateNewPerson() {
        var person = new Person("petro1", "Petro");
//        personService.process(new Event(PERSON_CREATED, person));
    }
}
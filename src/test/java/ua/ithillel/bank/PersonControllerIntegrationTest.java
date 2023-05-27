package ua.ithillel.bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import ua.ithillel.bank.repository.Person;
import ua.ithillel.bank.repository.PersonRepository;
import ua.ithillel.bank.service.PersonService;

import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PersonControllerIntegrationTest {

    @Autowired
    protected PersonRepository personRepository;

    @Autowired
    protected MockMvc mockMvc;

    @Test
    void test2() {
        System.out.println(personRepository.findAll());
    }

    @Test
    void shouldGetAllPersonsByName() throws Exception {
        var name = UUID.randomUUID().toString();

        personRepository.save(Person.builder()
                        .name(name)
                        .email("john.doe@example.com")
                        .uid(UUID.randomUUID().toString())
                        .build());

        personRepository.save(Person.builder()
                        .name(UUID.randomUUID().toString())
                        .email("john.smith@example.com")
                        .uid(UUID.randomUUID().toString())
                        .build());

        var query = get("/api/persons")
                .param("name", name);

        mockMvc.perform(query)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void test1() {
        System.out.println(personRepository.findAll());
    }
}
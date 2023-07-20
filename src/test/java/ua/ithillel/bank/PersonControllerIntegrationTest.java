package ua.ithillel.bank;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.Test;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import ua.ithillel.bank.config.WiremockConfig;
import ua.ithillel.bank.credit.score.model.IvInteger;
import ua.ithillel.bank.credit.score.model.IvString;
import ua.ithillel.bank.credit.score.model.SquidexResponse;
import ua.ithillel.bank.credit.score.model.SquidexResponseData;
import ua.ithillel.bank.repository.Person;
import ua.ithillel.bank.repository.PersonRepository;

import java.util.Map;
import java.util.UUID;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class PersonControllerIntegrationTest extends BaseIntegrationTest {


    @Test
    void shouldGetAllPersonsByName() throws Exception {
        MDC.put("test", "test");
        wireMockServer.stubFor(WireMock.post(urlEqualTo("/identity-server/connect/token"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(objectMapper.writeValueAsString(Map.of("access_token", "token")))));


        var response = SquidexResponse.builder()
                .data(SquidexResponseData.builder()
                        .name(IvString.builder().iv("John Doe").build())
                        .score(IvInteger.builder().iv(100).build())
                        .build())
                .build();

        wireMockServer.stubFor(WireMock.get(urlEqualTo("/api/content/hillel/credit-score/2bd7d78c-8763-480a-8492-38287bdc7d39"))
                .withHeader("Authorization", WireMock.equalTo("Bearer token"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(objectMapper.writeValueAsString(response))));

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

}
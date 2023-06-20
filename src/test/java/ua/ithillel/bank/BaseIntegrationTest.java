package ua.ithillel.bank;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ua.ithillel.bank.config.WiremockConfig;
import ua.ithillel.bank.repository.PersonRepository;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Testcontainers
public class BaseIntegrationTest {
    @Autowired
    protected PersonRepository personRepository;
    @Autowired
    protected WireMockServer wireMockServer;
    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected MockMvc mockMvc;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgresSQLContainer = new PostgreSQLContainer<>("postgres:15.1");

    @DynamicPropertySource
    public static void registerWiremockBaseUrl(DynamicPropertyRegistry registry) {
        registry.add("wiremock.baseurl", WiremockConfig.wireMockServer::baseUrl);
//        registry.add("spring.datasource.url", postgresSQLContainer::getJdbcUrl);
//        registry.add("spring.datasource.username", postgresSQLContainer::getUsername);
//        registry.add("spring.datasource.password", postgresSQLContainer::getPassword);
    }


}

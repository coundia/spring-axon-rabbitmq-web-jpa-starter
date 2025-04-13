package com.groupe2cs.bizyhub.shared;

import com.groupe2cs.bizyhub.products.infrastructure.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Profile;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "spring.config.name=application-test")
@Profile("test")
public class BaseIntegrationTests {

    @LocalServerPort
    public int port;

    @Autowired
    public TestRestTemplate testRestTemplate;

    @Autowired
    public ProductRepository productRepository;
    @Value("${host}")
    public String host;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
    }

    public String getBaseUrl() {
        return this.host + ":" + this.port + "/api/";
    }
}

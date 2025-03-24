package com.groupe2cs.bizyhub.shared;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(
        properties = "spring.config.name=application-test"
)
@Profile("test")
public class BaseUnitTests {

    public MockMvc mockMvc;

}
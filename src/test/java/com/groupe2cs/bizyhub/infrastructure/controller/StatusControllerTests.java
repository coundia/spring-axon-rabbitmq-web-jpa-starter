package com.groupe2cs.bizyhub.infrastructure.controller;

import com.groupe2cs.bizyhub.shared.BaseIntegrationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


public class StatusControllerTests extends BaseIntegrationTests {

    @Test
    void it_should_be_able_get_status() {
        ResponseEntity<String> response = testRestTemplate.getForEntity(host +":" +port + "/api/v1/status", String.class);
        assertThat(response.getBody()).isNotEmpty();
        Assertions.assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
    }
}

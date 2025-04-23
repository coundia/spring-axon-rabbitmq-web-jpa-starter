package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.axonframework.commandhandling.gateway.CommandGateway;

import java.util.List;

public class ApiKeyFindAllControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private ApiKeyRepository apikeyRepository;

@Autowired
private CommandGateway commandGateway;

@Test
void it_should_be_able_to_get_all_apikeys() {
	List<?> list = ApiKeyFixtures.randomManyViaCommand(commandGateway, 5);

	String uri = "/v1/queries/apiKeys";
	ResponseEntity<ApiKeyPagedResponse> response = this.getForEntity(uri, ApiKeyPagedResponse.class);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	assertThat(response.getBody()).isNotNull();
	assertThat(response.getBody().getContent()).isNotEmpty();
	}
}

package com.groupe2cs.bizyhub.security.presentation.controller;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.presentation.controller.UserFixtures;
import com.groupe2cs.bizyhub.tenant.presentation.controller.TenantFixtures;
import com.groupe2cs.bizyhub.security.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiKeyUpdateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private ApiKeyRepository apikeyRepository;

@Autowired
private CommandGateway commandGateway;

@Autowired
private CommandGateway commandGatewayUpdate;


@Test
void it_should_be_able_to_update_apikey() {

	String existingId = ApiKeyFixtures.randomOneViaCommand(commandGateway, getUserId()).getId().value();
	CreateApiKeyCommand updated = ApiKeyFixtures.randomOneViaCommand(commandGatewayUpdate, getUserId());

	ApiKeyFixtures.byIdWaitExist(apikeyRepository, existingId);
	ApiKeyFixtures.byIdWaitExist(apikeyRepository, updated.getId().value());

	ApiKeyRequest requestDTO = new ApiKeyRequest();
	 requestDTO.setAppKey(UUID.randomUUID().toString());
	 requestDTO.setUsername(UUID.randomUUID().toString());
	 requestDTO.setCreatedAt(java.time.Instant.now().plusSeconds(3600));
	 requestDTO.setExpiration(java.time.Instant.now().plusSeconds(3600));

	String uri = "/v1/commands/apiKey/" + existingId;
	ResponseEntity<String> response = this.put(uri,requestDTO);

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
}

package com.groupe2cs.bizyhub.tenant.presentation.controller;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.tenant.application.dto.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.*;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.presentation.controller.UserFixtures;
import com.groupe2cs.bizyhub.tenant.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class TenantCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;

@Test
void it_should_be_able_to_add_tenant() {

		TenantRequest requestDTO = new TenantRequest();

		requestDTO.setName(UUID.randomUUID().toString());
		requestDTO.setDescription(UUID.randomUUID().toString());
		requestDTO.setDomain(UUID.randomUUID().toString());
		requestDTO.setLanguage(UUID.randomUUID().toString());
		requestDTO.setActive(false);

 		String uri = "/v1/admin/commands/tenant";
		ResponseEntity<TenantResponse> response = this.postForEntity(uri, requestDTO, TenantResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getName()).isEqualTo(requestDTO.getName());
		assertThat(response.getBody().getDescription()).isEqualTo(requestDTO.getDescription());
		assertThat(response.getBody().getDomain()).isEqualTo(requestDTO.getDomain());
		assertThat(response.getBody().getLanguage()).isEqualTo(requestDTO.getLanguage());
		assertThat(response.getBody().getActive()).isEqualTo(requestDTO.getActive());
	}
}

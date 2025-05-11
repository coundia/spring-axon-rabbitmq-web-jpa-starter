package com.groupe2cs.bizyhub.security.presentation.controller;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.security.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiKeyCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;


@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_add_apikey() {

		ApiKeyRequest requestDTO = new ApiKeyRequest();

		requestDTO.setAppKey(UUID.randomUUID().toString());
		requestDTO.setUsername(UUID.randomUUID().toString());
		requestDTO.setActive(true);
		requestDTO.setCreatedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setExpiration(java.time.Instant.now().plusSeconds(3600));

 		String uri = "/v1/admin/commands/apiKey";
		ResponseEntity<ApiKeyResponse> response = this.postForEntity(uri, requestDTO, ApiKeyResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getAppKey()).isEqualTo(requestDTO.getAppKey());
		assertThat(response.getBody().getUsername()).isEqualTo(requestDTO.getUsername());
		assertThat(response.getBody().getActive()).isEqualTo(requestDTO.getActive());
		assertThat(response.getBody().getCreatedAt()).isEqualTo(requestDTO.getCreatedAt());
		assertThat(response.getBody().getExpiration()).isEqualTo(requestDTO.getExpiration());
	}
}

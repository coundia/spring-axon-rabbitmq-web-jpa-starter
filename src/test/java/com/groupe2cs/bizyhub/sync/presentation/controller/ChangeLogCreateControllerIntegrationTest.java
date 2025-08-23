package com.groupe2cs.bizyhub.sync.presentation.controller;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.sync.application.dto.*;
import com.groupe2cs.bizyhub.sync.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sync.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.sync.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class ChangeLogCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;


@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_add_changelog() {

		ChangeLogRequest requestDTO = new ChangeLogRequest();

		requestDTO.setEntityTable(UUID.randomUUID().toString());
		requestDTO.setEntityId(UUID.randomUUID().toString());
		requestDTO.setOperation(UUID.randomUUID().toString());
		requestDTO.setPayload(UUID.randomUUID().toString());
		requestDTO.setStatus(UUID.randomUUID().toString());
		requestDTO.setSyncAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setAttempts(46);
		requestDTO.setError(UUID.randomUUID().toString());

 		String uri = "/v1/commands/changeLog";
		ResponseEntity<ChangeLogResponse> response = this.postForEntity(uri, requestDTO, ChangeLogResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getEntityTable()).isEqualTo(requestDTO.getEntityTable());
		assertThat(response.getBody().getEntityId()).isEqualTo(requestDTO.getEntityId());
		assertThat(response.getBody().getOperation()).isEqualTo(requestDTO.getOperation());
		assertThat(response.getBody().getPayload()).isEqualTo(requestDTO.getPayload());
		assertThat(response.getBody().getStatus()).isEqualTo(requestDTO.getStatus());
		assertThat(response.getBody().getSyncAt()).isEqualTo(requestDTO.getSyncAt());
		assertThat(response.getBody().getAttempts()).isEqualTo(requestDTO.getAttempts());
		assertThat(response.getBody().getError()).isEqualTo(requestDTO.getError());
	}
}

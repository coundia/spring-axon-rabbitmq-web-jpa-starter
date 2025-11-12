package com.groupe2cs.bizyhub.message.presentation.controller;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.message.application.dto.*;
import com.groupe2cs.bizyhub.message.infrastructure.entity.*;
import com.groupe2cs.bizyhub.message.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.message.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class MessageCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;


@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_add_message() {

		MessageRequest requestDTO = new MessageRequest();

		requestDTO.setCode(UUID.randomUUID().toString());
		requestDTO.setEmail(UUID.randomUUID().toString());
		requestDTO.setPhone(UUID.randomUUID().toString());
		requestDTO.setContent(UUID.randomUUID().toString());
		requestDTO.setPlateforme(UUID.randomUUID().toString());
		requestDTO.setSource(UUID.randomUUID().toString());
		requestDTO.setAgent(UUID.randomUUID().toString());
		requestDTO.setStatus(UUID.randomUUID().toString());
		requestDTO.setDescription(UUID.randomUUID().toString());
		requestDTO.setIsActive(true);
		requestDTO.setIsDefault(true);
		requestDTO.setRemoteId(UUID.randomUUID().toString());
		requestDTO.setLocalId(UUID.randomUUID().toString());
		requestDTO.setDepotAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setSyncAt(java.time.Instant.now().plusSeconds(3600));

 		String uri = "/v1/commands/message";
		ResponseEntity<MessageResponse> response = this.postForEntity(uri, requestDTO, MessageResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getCode()).isEqualTo(requestDTO.getCode());
		assertThat(response.getBody().getEmail()).isEqualTo(requestDTO.getEmail());
		assertThat(response.getBody().getPhone()).isEqualTo(requestDTO.getPhone());
		assertThat(response.getBody().getContent()).isEqualTo(requestDTO.getContent());
		assertThat(response.getBody().getPlateforme()).isEqualTo(requestDTO.getPlateforme());
		assertThat(response.getBody().getSource()).isEqualTo(requestDTO.getSource());
		assertThat(response.getBody().getAgent()).isEqualTo(requestDTO.getAgent());
		assertThat(response.getBody().getStatus()).isEqualTo(requestDTO.getStatus());
		assertThat(response.getBody().getDescription()).isEqualTo(requestDTO.getDescription());
		assertThat(response.getBody().getIsActive()).isEqualTo(requestDTO.getIsActive());
		assertThat(response.getBody().getIsDefault()).isEqualTo(requestDTO.getIsDefault());
		assertThat(response.getBody().getRemoteId()).isEqualTo(requestDTO.getRemoteId());
		assertThat(response.getBody().getLocalId()).isEqualTo(requestDTO.getLocalId());
		assertThat(response.getBody().getDepotAt()).isEqualTo(requestDTO.getDepotAt());
		assertThat(response.getBody().getSyncAt()).isEqualTo(requestDTO.getSyncAt());
	}
}

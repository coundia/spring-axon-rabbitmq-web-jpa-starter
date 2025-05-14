package com.groupe2cs.bizyhub.chats.presentation.controller;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.chats.application.dto.*;
import com.groupe2cs.bizyhub.chats.infrastructure.entity.*;
import com.groupe2cs.bizyhub.chats.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.UserFixtures;
import com.groupe2cs.bizyhub.security.infrastructure.entity.User;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.Tenant;
import com.groupe2cs.bizyhub.tenant.infrastructure.entity.TenantFixtures;
import com.groupe2cs.bizyhub.tenant.infrastructure.repository.TenantRepository;
import com.groupe2cs.bizyhub.chats.application.command.*;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

public class ChatCreateControllerIntegrationTest extends BaseIntegrationTests {

@Autowired
private CommandGateway commandGateway;


@Autowired
private com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository accountDataRepository ;
@Autowired
private UserRepository createdByDataRepository ;
@Autowired
private TenantRepository tenantDataRepository ;

@Test
void it_should_be_able_to_add_chat() {

		ChatRequest requestDTO = new ChatRequest();

		requestDTO.setMessages(UUID.randomUUID().toString());
		requestDTO.setResponses(UUID.randomUUID().toString());
		requestDTO.setState(UUID.randomUUID().toString());
		requestDTO.setAccount(com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountFixtures.randomOneViaCommand(commandGateway,accountDataRepository, user).getId().value());
		requestDTO.setUpdatedAt(java.time.Instant.now().plusSeconds(3600));
		requestDTO.setReference(UUID.randomUUID().toString());

 		String uri = "/v1/commands/chat";
		ResponseEntity<ChatResponse> response = this.postForEntity(uri, requestDTO, ChatResponse.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
		assertThat(response.getBody().getMessages()).isEqualTo(requestDTO.getMessages());
		assertThat(response.getBody().getResponses()).isEqualTo(requestDTO.getResponses());
		assertThat(response.getBody().getState()).isEqualTo(requestDTO.getState());
		assertThat(response.getBody().getAccount()).isEqualTo(requestDTO.getAccount());
		assertThat(response.getBody().getUpdatedAt()).isEqualTo(requestDTO.getUpdatedAt());
		assertThat(response.getBody().getReference()).isEqualTo(requestDTO.getReference());
	}
}
